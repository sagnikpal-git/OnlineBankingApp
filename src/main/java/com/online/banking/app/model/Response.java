package com.online.banking.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Response {

	private Integer statusCode;
	private String successMessage;
	private Long accountNumber;	
}
