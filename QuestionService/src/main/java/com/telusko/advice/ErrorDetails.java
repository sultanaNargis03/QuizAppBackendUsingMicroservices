package com.telusko.advice;

import java.time.LocalDateTime;

public class ErrorDetails 
{
	private String statusCode;
	private String message;
	private LocalDateTime when;
	
	public ErrorDetails() 
	{
		
	}
	public ErrorDetails(String statusCode,String message,LocalDateTime when) 
	{
		this.statusCode = statusCode;
		this.message = message;
		this.when = when;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getWhen() {
		return when;
	}
	public void setWhen(LocalDateTime when) {
		this.when = when;
	}
	@Override
	public String toString() {
		return "ErrorDetails [statusCode=" + statusCode + ", message=" + message + ", when=" + when + "]";
	}
	
}
