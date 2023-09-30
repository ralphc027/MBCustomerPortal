package com.mb.application.bankservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.application.bankservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
