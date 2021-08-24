package com.online.banking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.banking.app.exceptions.UnableToTransferFundException;
import com.online.banking.app.model.BankAccountInfo;
import com.online.banking.app.model.Response;
import com.online.banking.app.model.TransferBalanceRequest;
import com.online.banking.app.service.FundTransferringService;

@RestController
public class FundTransferController {

	@Autowired
	FundTransferringService service;

	@RequestMapping(value = "/create-account-info", method = RequestMethod.POST)
	public ResponseEntity<BankAccountInfo> create(@RequestBody BankAccountInfo accountinfo) {
		BankAccountInfo BAI = service.save(accountinfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(BAI);
	}

	@RequestMapping(value = "/get-all-bank-details", method = RequestMethod.GET)

	public ResponseEntity<List<BankAccountInfo>> getAllAccountDetails() {
		List<BankAccountInfo> getaccounts = service.getAllAccounts();
		return ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}

	@PutMapping("/send-money")
	public ResponseEntity<ResponseEntity<Response>> SendMoney(
			@RequestBody TransferBalanceRequest transferBalanceRequest) throws UnableToTransferFundException {

		ResponseEntity<Response> transfer = service.TransferBalanceRequest(transferBalanceRequest);
		return ResponseEntity.status(HttpStatus.OK).body(transfer);

	}

}
