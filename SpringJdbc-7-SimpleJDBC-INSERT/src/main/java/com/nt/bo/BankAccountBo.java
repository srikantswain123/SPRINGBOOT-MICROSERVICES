package com.nt.bo;

import lombok.Data;

@Data
public class BankAccountBo {
	private long acno;
	private String holdername;
	private Float balance;
	private String status;

}
