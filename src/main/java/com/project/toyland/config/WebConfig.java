package com.project.toyland.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 설정 플래스
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/v1/**")
			.allowedOriginPatterns("https?://localhost(:[0-9]+)?") // 확장성으로 인해 권장
			.allowedMethods("*")
			.allowedHeaders("*")
			.exposedHeaders("Authorization", "Set-Cookie", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
			.allowCredentials(true);
	}
}