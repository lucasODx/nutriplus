package com.nutriplus.mcp_nutriplus_controle.tools;

import java.util.Map;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component 
public class IntegracaoTools {
    
    private final RestClient servicoControleNutricionalClient;

    public IntegracaoTools(RestClient servicoControleNutricionalClient) {
        this.servicoControleNutricionalClient = servicoControleNutricionalClient;
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
