package com.slumdogbiker.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.slumdogbiker.model.ApiErrors;

@ControllerAdvice
/**
 * 
 * @author ManikantaJV
 *
 */
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BikeNotFoundException.class)
	protected ResponseEntity<Object> handleBikeNotFoundException(BikeNotFoundException ex){
		String message = ex.getMessage(); 
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Bike Not Available";
		ApiErrors errors = new ApiErrors(timeStamp,message,HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);
	}
	
}
