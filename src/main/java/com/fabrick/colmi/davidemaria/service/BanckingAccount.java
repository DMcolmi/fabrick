package com.fabrick.colmi.davidemaria.service;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;

public interface BanckingAccount {

	AccountDetailDto getAccount(String accountId);

	AccountBalanceDto getAccountBalance(String accountId);

	AccountTransactionDto getAccountTransactions(String accountId, String dateFrom, String dateTo);
}