package com.nutriplus.mcp_nutriplus_pratica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientsConfig {
    @Bean
    RestClient servicoPraticaNutricionalClient(@Value("${servico.pratica.base-url}") String baseUrl) {
        return RestClient.builder().baseUrl(baseUrl).build();
    }
}