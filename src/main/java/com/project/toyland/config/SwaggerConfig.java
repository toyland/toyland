package com.project.toyland.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger 설정 플래스
 */
@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {

		Info info = new Info()
			.title("Toyland (토이랜드)")
			.version(springdocVersion)
			.description("없는거 빼고 다 있는 쇼핑몰 토이 프로젝트 Swagger UI");

		return new OpenAPI()
			.components(new Components())
			.info(info);
	}
}
