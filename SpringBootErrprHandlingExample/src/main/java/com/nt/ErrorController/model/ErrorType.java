package com.nt.ErrorController.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorType {
	
	private String msg;
	private String error;
	private String classType;

}
