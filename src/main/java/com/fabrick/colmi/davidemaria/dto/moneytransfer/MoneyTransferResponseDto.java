package com.fabrick.colmi.davidemaria.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferResponseDto {
    private String moneyTransferId;
    private String status;
    private String direction;
}
