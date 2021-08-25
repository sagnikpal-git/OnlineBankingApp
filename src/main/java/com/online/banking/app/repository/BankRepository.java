package com.online.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.banking.app.model.BankAccountInfo;

public interface BankRepository extends JpaRepository<BankAccountInfo, Integer> {
	
	public BankAccountInfo findByaccountNumber(Long accountNumber);

	public void save(Float currentSourceAmount);	

}
