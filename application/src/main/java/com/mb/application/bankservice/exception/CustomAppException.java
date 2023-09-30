package com.mb.application.bankservice.exception;

import org.springframework.http.HttpStatus;

import com.mb.application.bankservice.model.ResponseInfo;


public class CustomAppException extends Exception {
	

	private static final long serialVersionUID = 7118067073583300856L;
	

	private int transactionStatusCode;
	
	private String transactionStatusDescription;
	
	public CustomAppException() {}
	
	
	public CustomAppException(ResponseInfo responseInfo) {
		this.transactionStatusCode = responseInfo.getTransactionStatusCode();
		this.transactionStatusDescription = responseInfo.getTransactionStatusDescription();
	}

	public CustomAppException(HttpStatus status, int transactionStatusCode, String transactionStatusDescription) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}


	public CustomAppException(int transactionStatusCode, String transactionStatusDescription) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}

	public int getTransactionStatusCode() {
		return transactionStatusCode;
	}

	public void setTransactionStatusCode(int transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}

	public String getTransactionStatusDescription() {
		return transactionStatusDescription;
	}

	public void setTransactionStatusDescription(String transactionStatusDescription) {
		this.transactionStatusDescription = transactionStatusDescription;
	}
	

	@Override
	public String toString() {
		return "CustomAppException [transactionStatusCode=" + transactionStatusCode
				+ ", transactionStatusDescription=" + transactionStatusDescription + "]";
	}

}
