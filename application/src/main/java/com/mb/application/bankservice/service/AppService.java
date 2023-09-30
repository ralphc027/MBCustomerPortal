package com.mb.application.bankservice.service;

import javax.servlet.http.HttpServletRequest;


import com.mb.application.bankservice.exception.CustomAppException;
import com.mb.application.bankservice.model.CreateAccountRequest;

public interface AppService {
	
	Object createAccount (HttpServletRequest httpRequest, CreateAccountRequest requestBody) throws CustomAppException, Exception;
	
	Object getAccount (HttpServletRequest httpRequest, int customerNumber) throws CustomAppException, Exception;

}
