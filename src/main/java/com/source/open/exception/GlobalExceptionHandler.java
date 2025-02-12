package com.source.open.exception;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JacksonException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiJson> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {

		String paramName = ex.getName();

		String typeName = "";

		Class<?> type = ex.getRequiredType();
		if (type != null) {
			typeName = type.getSimpleName();
		}

		String message = "Parameter '%s' should be of type %s".formatted(paramName, typeName);

		ApiJson body = new ApiJson(message);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiJson> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(NotUniqueException.class)
	public ResponseEntity<ApiJson> notUniqueExceptionHandler(NotUniqueException ex) {

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiJson> badRequestExceptionHandler(BadRequestException ex) {

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<ApiJson> fileNotFoundExceptionHandler(FileNotFoundException ex) {

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(JacksonException.class)
	public ResponseEntity<ApiJson> jsonProcessingExceptionHandler(JacksonException ex) {

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(WebExchangeBindException.class)
	public ResponseEntity<Map<String, String>> webExchangeBindExceptionHandler(WebExchangeBindException ex) {

		log.debug("Web Exchange Bind Exception\n{}", ex);

		Map<String, String> body = new LinkedHashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			FieldError fr = (FieldError) error;
			String fieldName = fr.getField();
			String message = fr.getDefaultMessage();

			body.put(fieldName, message);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException ex) {

		log.debug("Method Argument Not Valid Exception\n{}", ex);

		Map<String, String> body = new LinkedHashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			FieldError fr = (FieldError) error;
			String fieldName = fr.getField();
			String message = fr.getDefaultMessage();

			body.put(fieldName, message);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(PropertyReferenceException.class)
	public ResponseEntity<ApiJson> propertyReferenceExceptionHandler(PropertyReferenceException ex) {

		log.debug("Property Reference Exception\n{}", ex);

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ApiJson> dataAccessExceptionHandler(DataAccessException ex) {

		log.debug("Data Access Exception\n{}", ex);

		ApiJson body = new ApiJson(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<Map<String, String>> constraintViolationExceptionHandler(ConstraintViolationException ex) {
//
//		Map<String, String> res = new LinkedHashMap<>();
//
//		ex.getConstraintViolations().forEach(error -> {
//			String fieldName = error.getPropertyPath().toString();
//			String message = error.getMessage();
//
//			res.put(fieldName, message);
//		});
//
//		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//	}

//	@ExceptionHandler(DataIntegrityViolationException.class)
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	public ResponseEntity<ApiJson> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex) {
//
//		ApiJson response = new ApiJson();
//
//		ex.printStackTrace();
//
//		response.setMessage(ex.getMessage());
//
//		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
//	}

}
