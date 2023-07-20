package com.fabrick.colmi.davidemaria.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fabrick.colmi.davidemaria.dto.AccountDetail;

@Service
public class FabrickApiService {

	private static final Logger logger = LoggerFactory.getLogger(FabrickApiService.class);
	private final WebClient webClient;

	public FabrickApiService(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<AccountDetail> getAccounts(String accountId) {
		return webClient.post().uri("/api/gbs/banking/v4.0/accounts/{accountId}", accountId)
				// .bodyValue(filter)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<AccountDetail>>() {
				}).onErrorMap(e -> {
					logger.error("Error LisIntegrationService.getResults", e);
					return e;
				}).block();
	}

}
