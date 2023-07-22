package com.fabrick.colmi.davidemaria.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.ApiBodyResponse;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferDto;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferResponseDto;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;
import com.fabrick.colmi.davidemaria.exceptionhandling.FabrickRestException;

@Service
public class FabrickApiService implements FabrickApi {

	private static final Logger logger = LoggerFactory.getLogger(FabrickApiService.class);
	private final WebClient webClient;

	public FabrickApiService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	@Override
	public ApiBodyResponse<AccountDetailDto> getAccount(String accountId) {
		return webClient.get().uri("/api/gbs/banking/v4.0/accounts/{accountId}", accountId)
				// .bodyValue(filter)
				.retrieve().bodyToMono(new ParameterizedTypeReference<ApiBodyResponse<AccountDetailDto>>() {
				}).onErrorMap(e -> {
					logger.error("Error FabrickApiService.getAccounts: ", e);
					return new FabrickRestException("Error FabrickApiService.getAccounts", e);
				}).block();
	}
	
	@Override
	public ApiBodyResponse<AccountBalanceDto> getAccountBalance(String accountId) {
		return webClient.get().uri("/api/gbs/banking/v4.0/accounts/{accountId}/balance", accountId).retrieve()
				.bodyToMono(new ParameterizedTypeReference<ApiBodyResponse<AccountBalanceDto>>() {
				}).onErrorMap(e -> {
					logger.error("Error FabrickApiService.getAccountBalance: ", e);
					return new FabrickRestException("Error FabrickApiService.getAccountBalance", e);
				}).block();

	}
	
	@Override
	public ApiBodyResponse<AccountTransactionDto> getAccountTransactions(String accountId, String fromDate,
			String toDate) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/api/gbs/banking/v4.0/accounts/{accountId}/transactions")
						.queryParam("fromAccountingDate", fromDate).queryParam("toAccountingDate", toDate)
						.build(accountId))
				.retrieve().bodyToMono(new ParameterizedTypeReference<ApiBodyResponse<AccountTransactionDto>>() {
				}).onErrorMap(e -> {
					logger.error("Error FabrickApiService.getAccountTransactions: ", e);
					return new FabrickRestException("Error FabrickApiService.getAccountTransactions", e);
				}).block();
	}
	
	@Override	
	public ApiBodyResponse<MoneyTransferResponseDto> createMoneyTransfer(String accountId, MoneyTransferDto moneyTransferDto) {
		return webClient.post().uri("/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers", accountId)
				.bodyValue(moneyTransferDto)
				.retrieve().bodyToMono(new ParameterizedTypeReference<ApiBodyResponse<MoneyTransferResponseDto>>() {
				}).onErrorMap(e -> {
					logger.error("Error FabrickApiService.createMoneyTransfer: ", e);
					return new FabrickRestException("Error FabrickApiService.createMoneyTransfer", e);
				}).block();
	}

}
