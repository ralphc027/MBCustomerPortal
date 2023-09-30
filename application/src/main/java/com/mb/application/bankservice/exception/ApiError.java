package com.mb.application.bankservice.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class ApiError {
	
	@JsonIgnore
	private HttpStatus status;
	
	private int transactionStatusCode;
	
	private String transactionStatusDescription;
	
	public ApiError () {}

	public ApiError(HttpStatus status) {
		this.status = status;
	}

	public ApiError(HttpStatus status, int transactionStatusCode, String transactionStatusDescription) {
		this.status = status;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
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
		return "ApiError [status=" + status + ", transactionStatusCode=" + transactionStatusCode
				+ ", transactionStatusDescription=" + transactionStatusDescription + "]";
	}
	
	

}
