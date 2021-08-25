package com.online.banking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.banking.app.model.CustomerRegistrationInfo;
import com.online.banking.app.repository.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationService {
	@Autowired
	CustomerRegistrationRepository repo;

	public CustomerRegistrationInfo getByuserId(Integer userId) {
		return repo.findByuserId(userId);
	}

	public CustomerRegistrationInfo getByAadharNumber(Long aadharNumber) {
		return repo.findByaadharNumber(aadharNumber);
	}

	public CustomerRegistrationInfo getByMobileNumber(Long mobileNumber) {
		return repo.findBymobileNumber(mobileNumber);
	}

	public CustomerRegistrationInfo CreateCustomerInfo(CustomerRegistrationInfo CustomerRegistrationInfo) {
		return repo.save(CustomerRegistrationInfo);
	}

	public List<CustomerRegistrationInfo> GetAllCustomers() {
		return repo.findAll();
	}

	public void DeleteCustomerInfo(Integer userId) {
		repo.deleteById(userId);
	}

	public CustomerRegistrationInfo UpdateCustomerInfo(CustomerRegistrationInfo customerinfo) {

		return repo.save(customerinfo);
	}

}
