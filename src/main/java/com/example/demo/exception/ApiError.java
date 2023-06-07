package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {

	private String message;//exception msg info
	private LocalDateTime locadatetime;//date and time of exception
	private String endPoint;//controller class which endpoint (url)
	private HttpStatus httpstatus;//error msg code
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocadatetime() {
		return locadatetime;
	}
	public void setLocadatetime(LocalDateTime locadatetime) {
		this.locadatetime = locadatetime;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	
}
