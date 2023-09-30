package com.mb.application.bankservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mb.application.bankservice.model.ResponseInfo;

@ControllerAdvice
public class CustomRBodyExceptionHandler {
	
	@ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseInfo handleException(BindException ex) {
		ResponseInfo errorResponse = new ResponseInfo(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
        return errorResponse;
    }

}
