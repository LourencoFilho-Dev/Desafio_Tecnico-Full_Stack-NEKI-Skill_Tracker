/*
package com.example.skilltracker.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Value("${prop.swagger.dev-url}")
    private String devUrl;

    @Bean
    OpenAPI myOpenAPI() {
        Server server = new Server();

        server.setUrl(devUrl);
        server.setDescription("Server URL - ambiente de desenvolvimento");

        Contact contact = new Contact();
        contact.setEmail("lourencofilho.ti@gmail.com");
        contact.setName("Flávio Lourenço");
        contact.setUrl("http://www.hostbr.com.br");

        Info info = new Info().title("Documentação API - Skill Tracker - Neki").version("1.0.0").contact(contact)
                .description("API com endpoints do Skill Tracker.")
                .termsOfService("http://www.hostbr.com.br/terms");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
*/