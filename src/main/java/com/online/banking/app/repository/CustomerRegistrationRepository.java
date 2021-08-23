package com.online.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.banking.app.model.CustomerRegistrationInfo;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationInfo, Integer> {
	
	public CustomerRegistrationInfo findByuserId (Integer userId);	
	public CustomerRegistrationInfo findByaadharNumber(Long aadharNumber);	
	public CustomerRegistrationInfo findBymobileNumber(Long mobileNumber);

}
