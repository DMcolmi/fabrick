package com.fabrick.colmi.davidemaria.service;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferDto;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferResponseDto;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;

/**
 *	interface that defines the methods used by the REST controller to manage operations on the account
 */
public interface BanckingAccount {

	AccountDetailDto getAccount(String accountId);

	AccountBalanceDto getAccountBalance(String accountId);

	AccountTransactionDto getAccountTransactions(String accountId, String dateFrom, String dateTo);

	MoneyTransferResponseDto createMoneyTransfer(String accountId, MoneyTransferDto moneyTransferDto);
}
