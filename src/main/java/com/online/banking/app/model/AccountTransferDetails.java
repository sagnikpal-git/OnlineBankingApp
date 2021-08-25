package com.online.banking.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class AccountTransferDetails {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long accountNumber;	
	private String AccountOwner;	
	private String IFSCCode;	
	private String branchName;	
	private Double currentBalance;
}
