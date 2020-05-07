package com.luis.demonstracao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket usuarioApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.luis.demonstracao"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo("API REST de Usuários",
				"API REST para gerenciar usuários.",
				"1.0",
				"All Rights Reserved",
				new Contact("Luis Guilherme", "https://gui-rod.github.io/", "gui.rod@yahoo.com"),
				"All Rights Reserved", "https://gui-rod.github.io/",
				new ArrayList<VendorExtension>());
		return apiInfo;
	}
	
}
