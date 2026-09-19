package com.nutriplus.mcp_nutriplus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientsConfig {

    @Bean
    RestClient servicoControleNutricionalClient(@Value("${servico.controle.base-url}") String baseUrl) {
        return RestClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    RestClient servicoTabelaNutricionalClient(@Value("${servico.tabela.base-url}") String baseUrl) {
        return RestClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    RestClient servicoPraticaNutricionalClient(@Value("${servico.pratica.base-url}") String baseUrl) {
        return RestClient.builder().baseUrl(baseUrl).build();
    }
}