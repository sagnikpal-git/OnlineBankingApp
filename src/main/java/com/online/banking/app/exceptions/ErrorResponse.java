package com.online.banking.app.exceptions;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class ErrorResponse {
	private HttpStatus status;
	private Date timeStamp;
	private String message;
	private List<String> errors;
}