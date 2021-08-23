package com.online.banking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.banking.app.exceptions.AadharNotFoundException;
import com.online.banking.app.exceptions.IdNotFoundException;
import com.online.banking.app.model.CustomerRegistrationInfo;
import com.online.banking.app.service.CustomerRegistrationService;


@RestController
public class CustomRegistrationController {
	@Autowired
	CustomerRegistrationService service;

	@RequestMapping(value="/GetCustomersBy{userId}", method=RequestMethod.GET)
	public ResponseEntity<CustomerRegistrationInfo> GetByUserId(@PathVariable Integer userId) throws IdNotFoundException{
		CustomerRegistrationInfo customerinfo=service.getByuserId(userId);
		if(customerinfo==null)
			throw new IdNotFoundException("Customer not found with the given Id::" +userId);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
			
		
	}
	@RequestMapping(value="/GetCustomersBy/{aadharNumber}", method=RequestMethod.GET)
	public ResponseEntity<CustomerRegistrationInfo> GetByAadharNumber(@PathVariable Long aadharNumber) throws AadharNotFoundException{
		
		CustomerRegistrationInfo customerinfo=service.getByAadharNumber(aadharNumber);
		if(customerinfo==null)
			throw new AadharNotFoundException("Customer not found with Aadhar Number::" +aadharNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
		
		
	}
	@RequestMapping(value="/CreateCustomer", method=RequestMethod.POST)
	public ResponseEntity<CustomerRegistrationInfo> CreateCustomerInfo
	(@RequestBody CustomerRegistrationInfo customerregistartioninfo){
		CustomerRegistrationInfo customerinfo=service.CreateCustomerInfo(customerregistartioninfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerinfo);
		
	}
	@RequestMapping(value="/GetAllCustomersInfo", method=RequestMethod.GET)
	public ResponseEntity<List<CustomerRegistrationInfo>> GetAllCutomers(){
		List<CustomerRegistrationInfo> customerinfo=service.GetAllCustomers();
				return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
			
		
	}
	
	
}
