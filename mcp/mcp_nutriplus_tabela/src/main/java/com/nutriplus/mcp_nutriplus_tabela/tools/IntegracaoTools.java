package com.nutriplus.mcp_nutriplus_tabela.tools;

import java.util.Map;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component 
public class IntegracaoTools {
    
    private final RestClient servicoTabelaNutricionalClient;

    public IntegracaoTools(RestClient servicoTabelaNutricionalClient) {
        this.servicoTabelaNutricionalClient = servicoTabelaNutricionalClient;
    }

    @McpTool(name = "criar_alimento", description = "Cadastra um novo alimento na Tabela Nutricional")
    public String criarAlimento(
            @McpToolParam(description = "Dados do alimento a ser cadastrado", required = true) Map<String, Object> alimento) {
        return servicoTabelaNutricionalClient.post()
                .uri("/api/alimentos")
                .body(alimento)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_alimentos", description = "Lista todos os alimentos cadastrados na Tabela Nutricional")
    public String listarAlimentos() {
        return servicoTabelaNutricionalClient.get()
                .uri("/api/alimentos")
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "criar_contraindicacao_alimento", description = "Cadastra uma contraindicação para um alimento")
    public String criarContraindicacaoAlimento(
            @McpToolParam(description = "Dados da contraindicação a ser cadastrada", required = true) Map<String, Object> contraindicacao) {
        return servicoTabelaNutricionalClient.post()
                .uri("/api/contraindicacoes-alimentos")
                .body(contraindicacao)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_contraindicacoes_alimentos", description = "Lista todas as contraindicações de alimentos cadastradas")
    public String listarContraindicacoesAlimentos() {
        return servicoTabelaNutricionalClient.get()
                .uri("/api/contraindicacoes-alimentos")
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "criar_receita", description = "Cadastra uma nova receita")
    public String criarReceita(
            @McpToolParam(description = "Dados da receita a ser cadastrada", required = true) Map<String, Object> receita) {
        return servicoTabelaNutricionalClient.post()
                .uri("/api/receitas")
                .body(receita)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_receitas", description = "Lista receitas, podendo filtrar por dificuldade ou por nome")
    public String listarReceitas(
            @McpToolParam(description = "Filtra pela dificuldade da receita (ex.: FACIL, MEDIA, DIFICIL). Se informado, o filtro por nome é ignorado", required = false) String dificuldade,
            @McpToolParam(description = "Filtra receitas pelo nome (busca parcial)", required = false) String nome) {
        return servicoTabelaNutricionalClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/receitas");
                    if (dificuldade != null && !dificuldade.isBlank()) {
                        uriBuilder.queryParam("dificuldade", dificuldade);
                    } else if (nome != null && !nome.isBlank()) {
                        uriBuilder.queryParam("nome", nome);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .body(String.class);
    }
    
}
