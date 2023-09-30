package com.mb.application.bankservice.model;

import java.io.Serializable;
import java.util.List;


public class GetCustomerResponse extends ResponseInfo implements Serializable{


	private static final long serialVersionUID = 3316198298055048499L;
	

	private String customerName;

	private int customerMobile;
	
	private String customerEmail;

	private String address1;
	
	private String address2;

	private List<Savings> savings;
	
	public GetCustomerResponse() {}

	public String getCustomerName() {
		return customerName;
	}
	
	public GetCustomerResponse(int transactionStatusCode, String transactionStatusDescription ,Customer customer, List<Savings> savings) {
		super.setTransactionStatusCode(transactionStatusCode);
		super.setTransactionStatusDescription(transactionStatusDescription);
		this.customerName = customer.getCustomerName();
		this.customerMobile = customer.getCustomerMobile();
		this.customerEmail = customer.getCustomerEmail();
		this.address1 = customer.getAddress1();
		this.address2 = customer.getAddress2();
		this.savings = savings;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(int customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public List<Savings> getSavings() {
		return savings;
	}

	public void setSavings(List<Savings> savings) {
		this.savings = savings;
	}

	
	
	
	
	
	
	

}
