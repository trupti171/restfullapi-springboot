package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerIdNotFoundException.class)
	
	public ResponseEntity<?> handleCustomerIdNotFoundException(CustomerIdNotFoundException ref,HttpServletRequest req){
		
		ApiError apiError=new ApiError();
		apiError.setMessage(ref.getMessage());
		apiError.setLocadatetime(LocalDateTime.now());
		apiError.setEndPoint(req.getRequestURI());
		apiError.setHttpstatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(apiError,apiError.getHttpstatus());
		
	}
}
