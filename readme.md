# 🥗 Nutriplus — Nutrição Personalizada

Plataforma de nutrição personalizada composta por múltiplos serviços que ajudam o usuário a controlar sua alimentação, consultar informações nutricionais e acompanhar sua evolução física.

## 📦 Serviços

| Serviço | Responsabilidade |
|---|---|
| **Controle Nutricional** | Registra e verifica o histórico de ingestão calórica do usuário. |
| **Tabela Nutricional** | Busca alimentos e consulta tabelas nutricionais e restrições alimentares. |
| **Prática Nutricional** | Calcula o gasto energético basal, registra treinos e define metas de ganho/perda de peso. |

## ✅ Pré-requisitos

Antes de começar, garanta que você tem instalado:

- **Java 26** (JDK 26)
- **Docker** e **Docker Compose**
- **Node.js 24** (necessário apenas para o cliente MCP via terminal)

## ⚙️ Configuração

1. Crie um arquivo `.env` na **raiz do projeto** (`Projeto Servicos Com MCP`), usando `.env.example` como base.
2. Crie também um arquivo `.env` dentro da pasta do **cliente MCP** (`mcp/client`), seguindo o mesmo `.env.example`.

## 🚀 Subindo os serviços

Na raiz do projeto e no projeto mcp, execute:

```bash
docker compose up --build -d
```

Isso irá construir e iniciar todos os serviços em segundo plano.

## 🖥️ Usando o cliente

Você pode acessar o Nutriplus de duas formas:

### Opção 1 — Cliente Web (HTML)
Basta abrir o arquivo do cliente HTML diretamente no navegador.

### Opção 2 — Cliente MCP (Terminal)

1. Acesse a pasta do cliente:
   ```bash
   cd mcp/client
   ```
2. Instale as dependências:
   ```bash
   npm install
   ```
3. Execute o cliente:
   ```bash
   node ./nutriplus_mcp_client.js
   ```

Pronto! O cliente MCP será aberto diretamente no terminal.