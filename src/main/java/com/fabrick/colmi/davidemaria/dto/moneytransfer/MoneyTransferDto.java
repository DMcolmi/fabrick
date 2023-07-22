package com.fabrick.colmi.davidemaria.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferDto {
    private CreditorDto creditor;
    private String executionDate;
    private String uri;
    private String description;
    private double amount;
    private String currency;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private TaxReliefDto taxRelief;
}
