package com.mb.application.bankservice.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class CreateAccountRequest implements Serializable{


	private static final long serialVersionUID = 1265438879647755819L;
	
	public CreateAccountRequest() {}
	
	

	public CreateAccountRequest( String customerName,  int customerMobile,  String customerEmail,
			 String addrerss1, String addrerss2,  String accountType) {
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = addrerss1;
		this.address2 = addrerss2;
		this.accountType = accountType;
	}

	@NotBlank(message = "Customer name is a required field")
	private String customerName;
	
	@Min(value = 1, message = "Mobile number is a required field")
	private int customerMobile;
	
	@NotBlank(message = "Customer email is a required field")
	private String customerEmail;
	
	@NotBlank(message = "Address 1 is a required field")
	private String address1;
	
	private String address2;
	
	@NotBlank(message = "Account type is a required field")
	private String accountType;

	public String getCustomerName() {
		return customerName;
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



	public void setAddress1(String addrerss1) {
		this.address1 = addrerss1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String addrerss2) {
		this.address2 = addrerss2;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	@Override
	public String toString() {
		return "User [customerName=" + customerName + ", customerMobile=" + customerMobile + ", customerEmail="
				+ customerEmail + ", address1=" + address1 + ", address2=" + address2 + ", accountType="
				+ accountType + "]";
	}
	
	
	

}
