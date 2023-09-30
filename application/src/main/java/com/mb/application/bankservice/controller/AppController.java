package com.mb.application.bankservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mb.application.bankservice.model.CreateAccountRequest;
import com.mb.application.bankservice.service.AppService;

@RestController
public class AppController {
	
	@Autowired
	AppService appService;
	
	// Creates User Account
	@PostMapping(value = "/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public <T> ResponseEntity<T> createUser(@Valid @RequestBody CreateAccountRequest createAccountRequest, HttpServletRequest httpRequest) throws Exception {
				
		return  (ResponseEntity<T>) ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
				.body(appService.createAccount(httpRequest, createAccountRequest));		
	}
	
	// Searches User Account
	@GetMapping(value = "/api/v1/account/{customerNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public <T> ResponseEntity<T> getUser(@PathVariable(value="customerNumber") int customerNumber, HttpServletRequest httpRequest) throws Exception {
					
			return  (ResponseEntity<T>) ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON)
					.body(appService.getAccount(httpRequest, customerNumber));		
	}

}
