
package com.nutriplus.controle_nutricional.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    String service_name = "tabela_nutricional";

    @GetMapping("/")
    public String healthCheck() {
        return String.format("O serviço %s está rodando", service_name);
    }
}