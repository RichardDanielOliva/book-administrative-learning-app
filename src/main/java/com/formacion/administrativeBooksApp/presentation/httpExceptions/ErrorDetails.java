package com.formacion.administrativeBooksApp.presentation.httpExceptions;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorDetails {
		
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ErrorObjectDetails> objectErrors;

	private ErrorDetails() {
	       timestamp = LocalDateTime.now();
	   }

	public  ErrorDetails(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	public ErrorDetails(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

    public ErrorDetails(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	}
    
    
    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }
    
    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getDefaultMessage(),
                fieldError.getRejectedValue());
    }
    
	public void addValidationError(List<ObjectError> globalErrors) {
		globalErrors.forEach(this::addValidationError);
    }
	
	private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }
	
	private void addValidationError(String object, String message) {
	    	addObjectError(new ErrorObjectDetails(object, message));
	}
	   
    private void addValidationError(String object, String field, String message, Object rejectedValue) {
        addObjectError(new ErrorObjectDetails(object, field, message,rejectedValue));
    }
    
    private void addObjectError(ErrorObjectDetails objectErrors) {
        if (this.objectErrors == null) {
        	this.objectErrors = new ArrayList<ErrorObjectDetails>();
        }
        this.objectErrors.add(objectErrors);
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public List<ErrorObjectDetails> getObjectErrors() {
		return objectErrors;
	}

	public void setObjectErrors(List<ErrorObjectDetails> objectErrors) {
		this.objectErrors = objectErrors;
	}  

}
