package com.mb.application.bankservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomAppException.class)
	protected ResponseEntity<Object> handleResetPasswordException(CustomAppException ex,
			HttpServletRequest request) {

		ApiError error = new ApiError(HttpStatus.BAD_REQUEST);
		error.setTransactionStatusCode(ex.getTransactionStatusCode());
		error.setTransactionStatusDescription(ex.getTransactionStatusDescription());
		return buildResponseEntity(error);

	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	
	
}
