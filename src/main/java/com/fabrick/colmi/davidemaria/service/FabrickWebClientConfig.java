package com.fabrick.colmi.davidemaria.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import static com.fabrick.colmi.davidemaria.commons.Constants.*;

/**
 * WebClient configuration class for Fabrick API
 */
@Configuration
public class FabrickWebClientConfig {

	@Bean
	public WebClient getWebClient() {
		return WebClient.builder().baseUrl(BASE_URL).defaultHeader(AUTH_SCHEMA, AUTH_SCHEMA_VALUE)
				.defaultHeader(API_KEY, API_KEY_VALUE).defaultHeader(TIME_ZONE, "")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();
	}

}
