package com.project.backend04.configure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server prodServer = new Server()
                .url("https://backendsp01-production.up.railway.app") // URL correcta y con https
                .description("Producción");

        return new OpenAPI()
                .info(new Info()
                        .title("API de Tareas")
                        .version("1.0")
                        .description("Documentación de la API de tareas"))
                .servers(List.of(prodServer));
    }
}