package com.apexglobal.apiEcommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Productos y Clima API")
						.version("1.0")
						.description("Documentación de la API de productos y clima"));
	}
}
