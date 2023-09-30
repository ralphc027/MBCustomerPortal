package com.mb.application.bankservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"transactionStatusCode", "transactionStatusDescription" })
public class ResponseInfo implements Serializable{


	private static final long serialVersionUID = 7553168472629554707L;
	
	private int transactionStatusCode;
	
	private String transactionStatusDescription;
	
	public ResponseInfo() {}
	
	public ResponseInfo(int transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}

	public ResponseInfo(int transactionStatusCode, String transactionStatusDescription) {
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
		return "ResponseError [transactionStatusCode=" + transactionStatusCode + ", transactionStatusDescription="
				+ transactionStatusDescription + "]";
	}

}
