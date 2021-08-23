package com.online.banking.app.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class TransferBalanceRequest {
	
private Integer FromAccountNumber;
private Integer ToAcccountNumber;
private BigDecimal amount;
}

