package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccountDto implements Serializable{
	private Long acno;
	private String holderName;
	private Float  balance;
	private String status;

}
