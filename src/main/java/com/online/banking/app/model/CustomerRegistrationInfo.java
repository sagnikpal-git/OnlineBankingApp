package com.online.banking.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
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
public class CustomerRegistrationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotEmpty(message = "Please enter your name")
	private String name;
	
	@NotNull(message ="Please enter your phone number")
	private Long mobileNumber;
	
	@Email(message = "Please enter a valid email id")
	private String emailId;
	
	@NotEmpty(message = "Please enter your address")
	private String address;
	
	@NotNull(message ="Please enter your aadhar card number")
	private Long aadharNumber;
	
	@NotEmpty(message = "Please Enter your organization name")
	private String employerName;
	
	@OneToOne(targetEntity = BankAccountInfo.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "Acc_no" ,referencedColumnName = "accountNumber")
	private BankAccountInfo BankAccountInfo;	
}
