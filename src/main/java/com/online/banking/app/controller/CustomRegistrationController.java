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

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomRegistrationController {
	@Autowired
	CustomerRegistrationService service;

	@RequestMapping(value = "/get-customer/{userId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get customer by Id", notes = "Find account details by user id")

	public ResponseEntity<CustomerRegistrationInfo> GetByUserId(@PathVariable Integer userId)
			throws IdNotFoundException {
		CustomerRegistrationInfo customerinfo = service.getByuserId(userId);
		if (customerinfo == null)
			throw new IdNotFoundException("Customer not found with the given Id::" + userId);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
	}

	@RequestMapping(value = "/get-customerby-uidai/{aadharNumber}", method = RequestMethod.GET)
	@ApiOperation(value = "Get customer by uidai", notes = "Find account details with aadhar number")

	public ResponseEntity<CustomerRegistrationInfo> GetByAadharNumber(@PathVariable Long aadharNumber)
			throws AadharNotFoundException {

		CustomerRegistrationInfo customerinfo = service.getByAadharNumber(aadharNumber);
		if (customerinfo == null)
			throw new AadharNotFoundException("Customer not found with Aadhar Number::" + aadharNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
	}

	@RequestMapping(value = "/create-customer", method = RequestMethod.POST)
	@ApiOperation(value = "Add a new account", notes = "Create a new account for customer")

	public ResponseEntity<CustomerRegistrationInfo> CreateCustomerInfo(
			@RequestBody CustomerRegistrationInfo customerregistartioninfo) {
		CustomerRegistrationInfo customerinfo = service.CreateCustomerInfo(customerregistartioninfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerinfo);
	}

	@RequestMapping(value = "/get-all-customers", method = RequestMethod.GET)
	@ApiOperation(value = "get all customers", notes = "Find account details of all customers")

	public ResponseEntity<List<CustomerRegistrationInfo>> GetAllCutomers() {
		List<CustomerRegistrationInfo> customerinfo = service.GetAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
	}

	@RequestMapping(value = "/update-customer/{userId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update customer details", notes = "Update customer information with user id in database")

	public ResponseEntity<String> UpdateCustomerInfo(@PathVariable Integer userId,
			@RequestBody CustomerRegistrationInfo user) throws IdNotFoundException {

		CustomerRegistrationInfo customerinfo = service.getByuserId(userId);
		if (customerinfo.getUserId() == null)
			throw new IdNotFoundException("Customer account not found with userid::" + userId);

		customerinfo.setAddress(user.getAddress());
		customerinfo.setAadharNumber(user.getAadharNumber());
		customerinfo.setBankAccountInfo(user.getBankAccountInfo());
		customerinfo.setEmailId(user.getEmailId());
		customerinfo.setMobileNumber(user.getMobileNumber());
		customerinfo.setName(user.getName());
		CustomerRegistrationInfo updatedetails = service.UpdateCustomerInfo(customerinfo);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete-customer-account/{userId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete customer and related accounts", notes = "Delete customer and account details associated with him")

	public HttpStatus deleteProduct(@PathVariable Integer userId) {
		service.DeleteCustomerInfo(userId);
		return HttpStatus.OK;
	}
}
