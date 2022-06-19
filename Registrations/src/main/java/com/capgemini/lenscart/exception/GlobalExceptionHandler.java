package com.capgemini.lenscart.exception;

import com.capgemini.lenscart.exception.*;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=NoDuplicateEmailIdException.class)
	public ResponseEntity<ExceptionResponce> handleDuplicateEmailId(NoDuplicateEmailIdException e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
		}
	

	@ExceptionHandler(value=NoDuplicateUserId.class)
	public ResponseEntity<ExceptionResponce> NoDuplicateUserId(NoDuplicateUserId e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
		}
}
