package com.fabrick.colmi.davidemaria.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrick.colmi.davidemaria.commons.Utils;
import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.ApiBodyResponse;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;

@Service
public class BanckingAccountService implements BanckingAccount {
	
	private static final Logger logger = LoggerFactory.getLogger(BanckingAccountService.class);
	
	@Autowired	
	FabrickApiService fabrickApiService;
	
	@Override
	public AccountDetailDto getAccount(String accountId) {
		logger.debug("getAccounts: {}", accountId);		
		ApiBodyResponse<AccountDetailDto> resposne = fabrickApiService.getAccount(accountId);		
		logger.debug("fabrickApiService.getAccounts complete with status code {}", resposne.getStatus());
		return resposne.getPayload();
	}
	
	@Override
	public AccountBalanceDto getAccountBalance(String accountId) {
		logger.debug("getAccountBalance: {}", accountId);		
		ApiBodyResponse<AccountBalanceDto> resposne = fabrickApiService.getAccountBalance(accountId);		
		logger.debug("fabrickApiService.getAccountBalance complete with status code {}", resposne.getStatus());
		return resposne.getPayload();
	}
	
	@Override
	public AccountTransactionDto getAccountTransactions(String accountId, String fromDate, String toDate) {
		logger.debug("getAccountTransactions: {}, fromDate: {}, toDate {}", accountId, fromDate, toDate);
		ApiBodyResponse<AccountTransactionDto> resposne = fabrickApiService.getAccountTransactions(accountId, Utils.validateDateInput(fromDate), Utils.validateDateInput(toDate));
		logger.debug("fabrickApiService.getAccountTransactions complete with status code {}", resposne.getStatus());
		return resposne.getPayload();
	}
}
