package com.fabrick.colmi.davidemaria.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxReliefDto {
	private String taxReliefId;
	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBeneficiaryDto naturalPersonBeneficiary;
	private LegalPersonBeneficiaryDto legalPersonBeneficiary;
}
