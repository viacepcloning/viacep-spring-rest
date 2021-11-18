package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vitaliy Fedoriv
 * @author marco.mangan@gmail.com
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception e) {
		ObjectMapper mapper = new ObjectMapper();
		ErrorInfo errorInfo = new ErrorInfo(e);
		String respJSONstring = "{}";
		try {
			respJSONstring = mapper.writeValueAsString(errorInfo);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return ResponseEntity.badRequest().body(respJSONstring);
	}
	
	private class ErrorInfo {
	    public final String className;
	    public final String exMessage;

	    public ErrorInfo(Exception ex) {
	        this.className = ex.getClass().getName();
	        this.exMessage = ex.getLocalizedMessage();
	    }
	}
}