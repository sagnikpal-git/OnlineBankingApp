package com.online.banking.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.banking.app.exceptions.UnableToTransferFundException;
import com.online.banking.app.model.BankAccountInfo;
import com.online.banking.app.model.Response;
import com.online.banking.app.model.TransferBalanceRequest;
@Service
public interface FundTransferringService{

public ResponseEntity<Response> TransferBalanceRequest(TransferBalanceRequest transferBalanceRequest) 
		throws UnableToTransferFundException;

public BankAccountInfo save(BankAccountInfo accountinfo);

public List<BankAccountInfo> getAllAccounts();


}