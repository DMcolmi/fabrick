package com.fabrick.colmi.davidemaria.dto.transaction;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
	private String transactionId;
	private String operationId;
	private Date accountingDate;
	private String valueDate;
	private TypeDto type;
	private int amount;
	private String currency;
	private String description;
}