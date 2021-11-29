package com.nt.bo;

import lombok.Data;

@Data
public class BankAccountBo {
	private Long acno;
	private String holderName;
	private Float  balance;
	private String status;

}
