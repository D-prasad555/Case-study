package com.cgt.trainapp.exception;

import java.time.LocalDateTime;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.relation.RoleNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cgt.trainapp.model.ErrorDetails;



@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler({TrainAlreadyExistsException.class})
	public ResponseEntity<ErrorDetails> handleProductNotFound(TrainAlreadyExistsException ex){
		ErrorDetails error=new ErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(ex.getMessage());
		error.setReason("id doesn't exist....");
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler({TrainNotFoundException.class})
	public ResponseEntity<ErrorDetails> handleEmployeeIdNotFound(TrainNotFoundException cart){
		ErrorDetails error=new ErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(cart.getMessage());
		error.setReason("id doesn't exist....");
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception ex){
			Map<String,Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp",LocalDateTime.now());
		body.put("Status",HttpStatus.NOT_ACCEPTABLE);
		body.put("Message",ex.getMessage());
		body.put("Reason","Wrong url typed....");
		return new ResponseEntity<Object>(body,HttpStatus.NOT_ACCEPTABLE);
	}
}