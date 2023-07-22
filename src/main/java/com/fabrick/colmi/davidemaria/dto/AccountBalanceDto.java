package com.fabrick.colmi.davidemaria.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceDto {	
	private Date date;
	private double balance;
	private double availableBalance;
	private String currency;
}
