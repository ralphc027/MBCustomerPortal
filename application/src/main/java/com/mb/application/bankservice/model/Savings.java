package com.mb.application.bankservice.model;

import java.math.BigInteger;

public class Savings {
	
	private int accountId;	
	private String accountType;
	private BigInteger availableBalance;
	
	public Savings() {}
	
	public Savings(Savings savings) {
		this.accountId = savings.getAccountId();
		this.accountType = savings.getAccountType();
		this.availableBalance = savings.getAvailableBalance();
	}

	public Savings(int accountId, String accountType, BigInteger availableBalance) {
		this.accountId = accountId;
		this.accountType = accountType;
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

	@Override
	public String toString() {
		return "CustomerAccountObj [accountId=" + accountId + ", accountType=" + accountType + ", availableBalance="
				+ availableBalance + "]";
	}
	
	

}
