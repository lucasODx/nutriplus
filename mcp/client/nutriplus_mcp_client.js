import "dotenv/config";
import readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";

import { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { StreamableHTTPClientTransport } from "@modelcontextprotocol/sdk/client/streamableHttp.js";

import { GoogleGenAI } from "@google/genai";

const MODELO = "gemini-3.1-flash-lite";
const PROMPT = `

PROMPT DE CONTEXTUALIZAÇÃO GERAL AQUI

Você é um assistente de nutrição de um app de registro alimentar e nutrição chamado Nutriplus, o seu nome é NutriBot.

Quando o usuário fizer uma saudação ou iniciar uma conversa contigo, você deve se identificar pelo seu nome e informar que você não é uma pessoa real mas é um assistente virtual.

Quando o usuário solicitar informações sobre alimentos, diario alimentar, metas nutricionais, registros de exercícios, receitas ou contraindicações de alimentos, você deve utilizar as ferramentas MCP disponíveis para obter tais informações. Também é necessário que você identifique quando mais de uma ferramenta é necessária. Você deve obedecer à essas regras:

- se o usuário perguntar sobre o alimentos, receitas ou contraindicações de alimentos, você deve utilizar as ferramentas de tabela nutricional;
- se o usuário perguntar sobre o registros de exercícios, você deve utilizar as ferramentas de pratica nutricional;
- se o usuário perguntar sobre diario alimentar ou metas nutricionais, você deve utilizar as ferramentas de controle nutricional;
- se o usuário fizer uma pergunta que não esteja relacionada a alimentos, receitas, contraindicações de alimentos, registros de exercícios, diario alimentar ou metas nutricionais, você deve dizer que não está capacitado para responder e que ele deve checar no cliente do Nutriplus ou com um profissional de saúde.;

`;

const SERVICOS_MCP = {
  controle_nutricional: "http://localhost:8084/mcp",
  tabela_nutricional: "http://localhost:8085/mcp",
  pratica_nutricional: "http://localhost:8086/mcp",
};


function criarStack() {
  const finalizadores = [];
  return {
    registrar(finalizador) {
      finalizadores.push(finalizador);
    },
    async closeAll() {
      while (finalizadores.length > 0) {
        const finalizador = finalizadores.pop();
        try {
          await finalizador();
        } catch (e) {
          console.warn(`⚠️ erro ao finalizar recurso: ${e.message}`);
        }
      }
    },
  };
}

async function iniciar() {
  let iniciado = false;
  const stack = criarStack();
  let clienteIA = null;

  try {
    clienteIA = new GoogleGenAI({ apiKey: process.env.GOOGLE_API_KEY });
    iniciado = true;
  } catch (e) {
    console.warn(`⚠️ erro iniciando conexão com IA: ${e.message}`);
  }

  return { iniciado, stack, clienteIA };
}

async function conectarServicos(stack) {
  const servicos = {};

  for (const [nomeServico, url] of Object.entries(SERVICOS_MCP)) {
    const transport = new StreamableHTTPClientTransport(new URL(url));
    const conexao = new Client({ name: "NutriBot", version: "1.0.0" });

    await conexao.connect(transport);
    stack.registrar(() => conexao.close());

    servicos[nomeServico] = conexao;
    console.log(`conectado ao serviço, '${nomeServico}'`);
  }

  return servicos;
}

async function getFerramentas(servicos) {
  const ferramentas = {};

  for (const [nomeServico, conexao] of Object.entries(servicos)) {
    const resultado = await conexao.listTools();

    for (const ferramenta of resultado.tools) {
      ferramentas[ferramenta.name] = {
        servico: {
          nome: nomeServico,
          conexao,
        },
        ferramenta: {
          type: "function",
          name: ferramenta.name,
          description: ferramenta.description,
          parameters: ferramenta.inputSchema,
        },
      };
    }
  }

  return ferramentas;
}

async function executarFerramenta(ferramentas, ferramentaDesejada, argumentos) {
  const ferramenta = ferramentas[ferramentaDesejada];

  const servico = ferramenta.servico;
  console.log(`🤖 executando a ferramenta, '${ferramentaDesejada}', do serviço, '${servico.nome}'`);

  const conexao = servico.conexao;
  const resultado = await conexao.callTool({
    name: ferramentaDesejada,
    arguments: argumentos,
  });

  return extrairTexto(resultado);
}

function extrairTexto(resultado) {
  if (resultado.structuredContent) {
    return JSON.stringify(resultado.structuredContent);
  }

  const conteudo = [];
  for (const c of resultado.content ?? []) {
    if (c && typeof c.text === "string") {
      conteudo.push(c.text);
    } else {
      conteudo.push(String(c));
    }
  }

  return conteudo.join("\n");
}

async function chat(clienteIA, ferramentas) {
  const rl = readline.createInterface({ input, output });

  const mensagens = [
    {
      type: "user_input",
      content: [{ type: "text", text: PROMPT }],
    },
  ];

  const ferramentasParaModelo = Object.values(ferramentas).map((f) => f.ferramenta);

  try {
    while (true) {
      let mensagem = await rl.question("\n ☺️: ");
      mensagem = mensagem.toLowerCase();

      if (mensagem === "sair" || mensagem === "/s") {
        break;
      }

      mensagens.push({
        type: "user_input",
        content: [{ type: "text", text: mensagem }],
      });

      while (true) {
        const resposta = await clienteIA.interactions.create({
          model: MODELO,
          input: mensagens,
          tools: ferramentasParaModelo,
        });

        const execucoes = (resposta.steps ?? []).filter((item) => item.type === "function_call");

        if (execucoes.length === 0) {
          console.log(`🤖 ${resposta.output_text}`);
          break;
        }

        mensagens.push(...resposta.steps);

        for (const execucao of execucoes) {
          const argumentos = execucao.arguments;
          const resultado = await executarFerramenta(ferramentas, execucao.name, argumentos);

          mensagens.push({
            type: "function_result",
            name: execucao.name,
            call_id: execucao.id,
            result: [{ type: "text", text: resultado }],
          });
        }
      }
    }
  } finally {
    rl.close();
  }
}

async function finalizar(stack) {
  await stack.closeAll();
}

async function executar() {
  const { iniciado, stack, clienteIA } = await iniciar();

  if (iniciado) {
    try {
      const servicos = await conectarServicos(stack);
      const ferramentas = await getFerramentas(servicos);

      await chat(clienteIA, ferramentas);
    } finally {
      await finalizar(stack);
    }
  }
}

executar();