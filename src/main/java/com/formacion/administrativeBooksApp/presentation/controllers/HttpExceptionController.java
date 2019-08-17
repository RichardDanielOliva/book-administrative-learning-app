package com.formacion.administrativeBooksApp.presentation.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.formacion.administrativeBooksApp.presentation.httpExceptions.ErrorDetails;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class HttpExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        //INCLUIR LOG
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), ex);

		return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
	
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest request) {
    	ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST);
    	errorDetails.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
    	errorDetails.setDebugMessage(ex.getMessage());
    	
        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }

    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,WebRequest request) {
    	ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNPROCESSABLE_ENTITY);
    	errorDetails.setMessage("Validation error");
    	errorDetails.addValidationErrors(ex.getBindingResult()
    			.getFieldErrors());
    	errorDetails.addValidationError(ex.getBindingResult()
    			.getGlobalErrors());
        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalExceptionHandler(Exception ex, WebRequest request) {
    	ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
}
