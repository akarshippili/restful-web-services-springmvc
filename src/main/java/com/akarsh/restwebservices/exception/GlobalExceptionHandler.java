package com.akarsh.restwebservices.exception;

import com.akarsh.restwebservices.exception.custom.ForbiddenException;
import com.akarsh.restwebservices.exception.custom.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
        ErrorDetails errorDetails =  new ErrorDetails(exception.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorDetails> handleForbiddenException(ForbiddenException exception, WebRequest request){
        ErrorDetails errorDetails =  new ErrorDetails(exception.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI(),HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,String> map = new LinkedHashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDetails errorDetails =  new ErrorDetails("Argument Not Valid Error", ((ServletWebRequest)request).getRequest().getRequestURI(),HttpStatus.NOT_FOUND, map);
        return handleExceptionInternal(ex, errorDetails , headers, status, request);
    }

}
