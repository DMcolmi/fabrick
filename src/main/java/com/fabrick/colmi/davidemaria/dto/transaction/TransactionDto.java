package com.fabrick.colmi.davidemaria.dto.transaction;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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