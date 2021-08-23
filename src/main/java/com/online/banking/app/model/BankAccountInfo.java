package com.online.banking.app.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class BankAccountInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Please enter the Account Number")
	private Integer accountNumber;

	@NotEmpty(message = "Please enter the IFSC code")
	private String ifsccode;

	private String branchName;

	@NotNull(message = "Please Enter the Balance Amount")
	private BigDecimal availableBalance;
}
