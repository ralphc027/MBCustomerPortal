package com.mb.application.bankservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.application.bankservice.model.CustomerAccount;


public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {
	
	CustomerAccount findById(int customerId);

}
