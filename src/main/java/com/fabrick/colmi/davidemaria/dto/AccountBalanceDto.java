package com.fabrick.colmi.davidemaria.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountBalanceDto {	
	private Date date;
	private double balance;
	private double availableBalance;
	private String currency;
}
