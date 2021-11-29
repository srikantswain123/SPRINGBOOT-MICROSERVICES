package com.nt.dto;

import lombok.Data;

@Data
public class BankAccountDto {
	private long acno;
	private String holdername;
	private Float balance;
	private String status;


}
