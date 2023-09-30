package com.mb.application.bankservice.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAccount {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;	
	private String accountType;
	private String accountTypeDescription;
	private BigInteger availableBalance;
	
	public CustomerAccount () {}
	

	public CustomerAccount(String accountType, BigInteger availableBalance) {
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}
	
	


	public CustomerAccount(String accountType, String accountTypeDescription, BigInteger availableBalance) {
		super();
		this.accountType = accountType;
		this.accountTypeDescription = accountTypeDescription;
		this.availableBalance = availableBalance;
	}


	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigInteger getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigInteger availableBalance) {
		this.availableBalance = availableBalance;
	}


	public String getAccountTypeDescription() {
		return accountTypeDescription;
	}


	public void setAccountTypeDescription(String accountTypeDescription) {
		this.accountTypeDescription = accountTypeDescription;
	}


	@Override
	public String toString() {
		return "CustomerAccount [accountId=" + accountId + ", accountType=" + accountType + ", accountTypeDescription="
				+ accountTypeDescription + ", availableBalance=" + availableBalance + "]";
	}

	
}
