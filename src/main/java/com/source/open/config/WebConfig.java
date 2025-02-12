package com.source.open.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	@Bean
	CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration corsConfig = new CorsConfiguration();

		corsConfig.setAllowCredentials(true);

		corsConfig.addAllowedOriginPattern("*");

		corsConfig.setAllowedHeaders(List.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT));

		corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));

		corsConfig.setMaxAge(3600L);

//		IN PRODUCTION DON'T ALLOW /** ONLY ALLOW SPECIFIY URL
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsFilter(source);
	}

}
