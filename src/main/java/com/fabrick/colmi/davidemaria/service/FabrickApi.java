package com.fabrick.colmi.davidemaria.service;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.ApiBodyResponse;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferDto;
import com.fabrick.colmi.davidemaria.dto.moneytransfer.MoneyTransferResponseDto;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;

/**
 * Interface that defines the methods that consume the APIs exposed by Fabrick
 */
public interface FabrickApi {

	ApiBodyResponse<AccountDetailDto> getAccount(String accountId);

	ApiBodyResponse<AccountBalanceDto> getAccountBalance(String accountId);

	ApiBodyResponse<AccountTransactionDto> getAccountTransactions(String accountId, String fromDate, String toDate);

	ApiBodyResponse<MoneyTransferResponseDto> createMoneyTransfer(String accountId, MoneyTransferDto moneyTransferDto);

}
