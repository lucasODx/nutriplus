package com.nutriplus.mcp_nutriplus.tools;

import java.util.Map;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component 
public class IntegracaoTools {
    
    private final RestClient servicoControleNutricionalClient;
    private final RestClient servicoTabelaNutricionalClient;
    private final RestClient servicoPraticaNutricionalClient;

    public IntegracaoTools(RestClient servicoControleNutricionalClient, RestClient servicoTabelaNutricionalClient, RestClient servicoPraticaNutricionalClient) {
        this.servicoControleNutricionalClient = servicoControleNutricionalClient;
        this.servicoTabelaNutricionalClient = servicoTabelaNutricionalClient;
        this.servicoPraticaNutricionalClient = servicoPraticaNutricionalClient;
    }

    @McpTool(name = "criar_alimento", description = "Cadastra um novo alimento na Tabela Nutricional")
    public String criarAlimento(
            @McpToolParam(description = "Dados do alimento a ser cadastrado", required = true) Map<String, Object> alimento) {
        return servicoControleNutricionalClient.post()
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
        return servicoPraticaNutricionalClient.post()
                .uri("/api/contraindicacoes-alimentos")
                .body(contraindicacao)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_contraindicacoes_alimentos", description = "Lista todas as contraindicações de alimentos cadastradas")
    public String listarContraindicacoesAlimentos() {
        return servicoPraticaNutricionalClient.get()
                .uri("/api/contraindicacoes-alimentos")
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "criar_diario_alimentar", description = "Cria um novo registro de diário alimentar")
    public String criarDiarioAlimentar(
            @McpToolParam(description = "Dados do diário alimentar a ser criado", required = true) Map<String, Object> diario) {
        return servicoControleNutricionalClient.post()
                .uri("/api/diarios-alimentares")
                .body(diario)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_diarios_alimentares", description = "Lista todos os registros de diário alimentar")
    public String listarDiariosAlimentares() {
        return servicoControleNutricionalClient.get()
                .uri("/api/diarios-alimentares")
                .retrieve()
                .body(String.class);
    }
    
}
