package com.fabrick.colmi.davidemaria.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditorDto {
    private String name;
    private AccountDto account;
    private AddressDto address;
}
