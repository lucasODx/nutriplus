
package com.nutriplus.tabela_nutricional.controller; 

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    String service_name = "tabela_nutricional";

    @GetMapping("/api")
    public String healthCheck() {
        return String.format("O serviço %s está rodando", service_name);
    }
}