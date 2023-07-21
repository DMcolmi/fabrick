package com.fabrick.colmi.davidemaria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;
import com.fabrick.colmi.davidemaria.service.BanckingAccountService;

@RestController
@RequestMapping("/api/bancking-account")
public class BanckingAccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(BanckingAccountController.class);
	
	@Autowired	
	BanckingAccountService banckingAccountService;
	
    @GetMapping("/")
    public AccountDetailDto getAccount(@RequestParam(name = "accountId") String accountId) {
    	logger.debug("getAccount: {}", accountId);
    	return banckingAccountService.getAccount(accountId);
    }
    
    @GetMapping("/account-balance")
    public AccountBalanceDto getAccountBalance(@RequestParam(name = "accountId") String accountId) {
    	logger.debug("getAccountBalance: {}", accountId);
    	return banckingAccountService.getAccountBalance(accountId);
    }
    
	@GetMapping("/account-transactions")
	public AccountTransactionDto getAccountTransactions(@RequestParam(name = "accountId") String accountId,
			@RequestParam(name = "fromDate") String fromDate, @RequestParam(name = "toDate") String toDate) {
		logger.debug("getAccountTransactions: {}, fromDate: {}, toDate {}", accountId, fromDate, toDate);
		return banckingAccountService.getAccountTransactions(accountId, fromDate, toDate);
	}
}
