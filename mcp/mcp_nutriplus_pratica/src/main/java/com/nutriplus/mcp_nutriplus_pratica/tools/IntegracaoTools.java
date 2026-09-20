package com.nutriplus.mcp_nutriplus_pratica.tools;

import java.util.Map;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component 
public class IntegracaoTools {
    
    private final RestClient servicoPraticaNutricionalClient;

    public IntegracaoTools(RestClient servicoPraticaNutricionalClient) {
        this.servicoPraticaNutricionalClient = servicoPraticaNutricionalClient;
    }

    @McpTool(name = "criar_registro_exercicio", description = "Cria um novo registro de exercício")
    public String criarRegistroExercicio(
            @McpToolParam(description = "Dados do registro de exercício a ser criado", required = true) Map<String, Object> registroExercicio) {
        return servicoPraticaNutricionalClient.post()
                .uri("/api/registros-exercicios")
                .body(registroExercicio)
                .retrieve()
                .body(String.class);
    }

    @McpTool(name = "listar_registros_exercicios", description = "Lista todos os registros de exercício")
    public String listarRegistrosExercicios() {
        return servicoPraticaNutricionalClient.get()
                .uri("/api/registros-exercicios")
                .retrieve()
                .body(String.class);
    }


}
