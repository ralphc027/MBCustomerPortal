package com.mb.application.bankservice.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mb.application.bankservice.model.ResponseInfo;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    ResponseInfo errorResponse = new ResponseInfo(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomAppException.class)
	protected ResponseEntity<Object> handleCustomException(CustomAppException ex,
			HttpServletRequest request) {

		ApiError error = new ApiError(ex.getHttpStatus());
		error.setTransactionStatusCode(ex.getTransactionStatusCode());
		error.setTransactionStatusDescription(ex.getTransactionStatusDescription());
		return buildResponseEntity(error);

	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	
	
}
