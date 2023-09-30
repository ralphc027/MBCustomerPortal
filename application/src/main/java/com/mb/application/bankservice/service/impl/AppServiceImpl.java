package com.mb.application.bankservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mb.application.bankservice.dao.CustomerRepository;
import com.mb.application.bankservice.exception.CustomAppException;
import com.mb.application.bankservice.model.CreateAccountRequest;
import com.mb.application.bankservice.model.CreateAccountResponse;
import com.mb.application.bankservice.model.Customer;
import com.mb.application.bankservice.model.CustomerAccount;
import com.mb.application.bankservice.model.GetCustomerResponse;
import com.mb.application.bankservice.model.ResponseInfo;
import com.mb.application.bankservice.model.Savings;
import com.mb.application.bankservice.service.AppService;
import com.mb.application.util.Constants;

@Service
public class AppServiceImpl implements AppService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Transactional
	@Override
	public Object createAccount(HttpServletRequest httpRequest, CreateAccountRequest requestBody)
			throws CustomAppException, Exception {
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.BAD_REQUEST.value());
		String custEmail = requestBody.getCustomerEmail();
		String accountType = requestBody.getAccountType();
		
		// Validate Email
		boolean validEmail = EmailValidator.getInstance().isValid(custEmail);
		if(!validEmail) {
			responseInfo.setTransactionStatusDescription("Email input is invalid");
			throw new CustomAppException(responseInfo, HttpStatus.BAD_REQUEST);
		}
		
		// Validate Account Type
		if(!accountType.equalsIgnoreCase(Constants.ACC_TYP_Y) && !accountType.equalsIgnoreCase(Constants.ACC_TYP_SAVINGS) && !accountType.equalsIgnoreCase(Constants.ACC_TYP_CHECKING)) {
			responseInfo.setTransactionStatusDescription("Account Type input is invalid");
			throw new CustomAppException(responseInfo, HttpStatus.BAD_REQUEST);
		}
		
		//Set Account
		List<CustomerAccount> accountList = new ArrayList<CustomerAccount>();
		CustomerAccount account = new CustomerAccount();
		account.setAccountType(requestBody.getAccountType());
		account.setAccountTypeDescription(getAccountDescription(requestBody.getAccountType()));
		account.setAvailableBalance(Constants.DEFAULT_BALANCE);
		accountList.add(account);
		
		// Create Customer
		Customer customer = new Customer();
		customer.setCustomerName(requestBody.getCustomerName());
		customer.setCustomerMobile(requestBody.getCustomerMobile());
		customer.setCustomerEmail(requestBody.getCustomerEmail());
		customer.setAddress1(requestBody.getAddress1());
		customer.setAddress2(requestBody.getAddress2());
		customer.setAccounts(accountList);
		customerRepository.save(customer);
		
		responseInfo.setTransactionStatusCode(HttpStatus.CREATED.value());
		responseInfo.setTransactionStatusDescription("Customer account created");
		CreateAccountResponse response = new CreateAccountResponse(responseInfo, customer.getCustomerId());
		return response;
	}
	
	
	
	@Override
	public Object getAccount(HttpServletRequest httpRequest, int customerNumber) throws CustomAppException, Exception {
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.NOT_FOUND.value(),"Customer Not Found");
		Optional<Customer> customer = customerRepository.findById(customerNumber);
		
		// Validate if there is no Customer Found
		if(customer.isEmpty()) {
			throw new CustomAppException(responseInfo, HttpStatus.NOT_FOUND);
		}
		
		// Filter Custoemr Accounts to get Savings accounts
		List<Savings> savingList = new ArrayList<Savings>();
		for(CustomerAccount accounts : customer.get().getAccounts()) {
			if(accounts.getAccountType().equalsIgnoreCase(Constants.ACC_TYP_SAVINGS)) {
				Savings savings = new Savings(accounts.getAccountId(), accounts.getAccountTypeDescription(), accounts.getAvailableBalance());
				savingList.add(savings);
			}
		}
		
		GetCustomerResponse response = new GetCustomerResponse(HttpStatus.FOUND.value(),"Customer Account Found",customer.get(), savingList);
		return response;
	}



	public String getAccountDescription(String accountType) {
		String description = "";
		if(accountType.equalsIgnoreCase(Constants.ACC_TYP_Y)) description = Constants.ACC_TYP_Y_DESC;
		if(accountType.equalsIgnoreCase(Constants.ACC_TYP_SAVINGS)) description = Constants.ACC_TYP_SAVINGS_DESC;
		if(accountType.equalsIgnoreCase(Constants.ACC_TYP_CHECKING)) description = Constants.ACC_TYP_CHECKING_DESC;
		return description;
	}

}
