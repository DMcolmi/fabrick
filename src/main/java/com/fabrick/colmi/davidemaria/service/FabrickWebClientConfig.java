package com.fabrick.colmi.davidemaria.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FabrickWebClientConfig {
	
    @Bean
    public WebClient getWebClient() {
        return WebClient.builder().baseUrl("https://api.example.com")
                .defaultHeader("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .defaultHeader("Auth-Schema", "S2S")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

}
