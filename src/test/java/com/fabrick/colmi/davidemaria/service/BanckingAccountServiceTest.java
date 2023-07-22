package com.fabrick.colmi.davidemaria.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fabrick.colmi.davidemaria.dto.AccountBalanceDto;
import com.fabrick.colmi.davidemaria.dto.AccountDetailDto;
import com.fabrick.colmi.davidemaria.dto.ApiBodyResponse;
import com.fabrick.colmi.davidemaria.dto.transaction.AccountTransactionDto;
import com.fabrick.colmi.davidemaria.dto.transaction.TransactionDto;


/**
 * Unit test example for the BanckingAccountService class
 */
@ExtendWith(MockitoExtension.class)
class BanckingAccountServiceTest {
	
	private static final String ACCOUNT = "14537780";

	@Mock
	private FabrickApiService fabrickApiService;	
	
	@InjectMocks
	private BanckingAccountService banckingAccountService;
	
	@Test
	void BanckingAccountService_GetAccount_ReturnsAccountDetailDto() {
		String accountId = ACCOUNT;
		AccountDetailDto accountDto = new AccountDetailDto(ACCOUNT, "IT40L0326822311052923800661", "03268", "22311",
				"IT", "40", "L", "52923800661", "Test api", "Conto Websella", "LUCA TERRIBILE", "2016-12-14", "EUR");
		ApiBodyResponse<AccountDetailDto> accountDtoResposne = new ApiBodyResponse<>();
		accountDtoResposne.setPayload(accountDto);
		
		when(fabrickApiService.getAccount(accountId)).thenReturn(accountDtoResposne);
		
		ApiBodyResponse<AccountDetailDto> accountDtoResponseFromService = fabrickApiService.getAccount(accountId);
		
		assertThat(accountDto.getAccount()).isEqualTo(accountDtoResponseFromService.getPayload().getAccount());
	}
	
	@Test
	void BanckingAccountService_GetAccountBalance_ReturnsAccountBalanceDto() {
		String accountId = ACCOUNT;
		
		AccountBalanceDto balanceDto = new AccountBalanceDto(new Date(),100,100, "EUR" );
		ApiBodyResponse<AccountBalanceDto> balanceDtoResposne = new ApiBodyResponse<>();
		balanceDtoResposne.setPayload(balanceDto);
		
		when(fabrickApiService.getAccountBalance(accountId)).thenReturn(balanceDtoResposne);
		
		ApiBodyResponse<AccountBalanceDto> accountDtoResponseFromService = fabrickApiService.getAccountBalance(accountId);
		
		assertThat(balanceDto.getBalance()).isEqualTo(accountDtoResponseFromService.getPayload().getBalance());
	}
	
	@Test
	void BanckingAccountService_GetAccountTransactions_ReturnsAccountTransactions() {
		String accountId = ACCOUNT;
		
		AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
		List<TransactionDto> transactionDtoList = new ArrayList<>();
		accountTransactionDto.setList(transactionDtoList);
		transactionDtoList.add(new TransactionDto());
		
		ApiBodyResponse<AccountTransactionDto> accountTransactionDtoResposne = new ApiBodyResponse<>();
		accountTransactionDtoResposne.setPayload(accountTransactionDto);
		
		when(fabrickApiService.getAccountTransactions(accountId, "", "")).thenReturn(accountTransactionDtoResposne);
		
		ApiBodyResponse<AccountTransactionDto> accountDtoResponseFromService = fabrickApiService.getAccountTransactions(accountId, "", "");
		
		assertThat(accountTransactionDto.getList()).hasSameSizeAs(accountDtoResponseFromService.getPayload().getList());
	}

}
