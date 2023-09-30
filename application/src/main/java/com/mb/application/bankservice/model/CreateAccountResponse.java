package com.mb.application.bankservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({ "customerNumber", "transactionStatusCode", "transactionStatusDescription" })
@JsonPropertyOrder(alphabetic = true)
public class CreateAccountResponse extends ResponseInfo implements Serializable {


	private static final long serialVersionUID = 1685422139412449003L;
	
	private int  customerNumber;
	
	public CreateAccountResponse () {}
	
	public CreateAccountResponse(ResponseInfo info ,int customerNumber) {
		super.setTransactionStatusCode(info.getTransactionStatusCode());
		super.setTransactionStatusDescription(info.getTransactionStatusDescription());
		this.customerNumber = customerNumber;
	}

	public CreateAccountResponse(int transactionStatusCode, String transactionStatusDescription ,int customerNumber) {
		super.setTransactionStatusCode(transactionStatusCode);
		super.setTransactionStatusDescription(transactionStatusDescription);
		this.customerNumber = customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "CreateAccountResponse [customerNumber=" + customerNumber + ", transactionStatusCode="
				+ getTransactionStatusCode() + ", transactionStatusDescription="
				+ getTransactionStatusDescription() + "]";
	}
	
	

	

}
