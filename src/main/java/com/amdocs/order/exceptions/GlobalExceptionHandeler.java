package com.amdocs.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest)
    {
        ErrorDetails errorDetails=new ErrorDetails(new Date(),resourceNotFoundException.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    ResponseEntity<ErrorDetails> globalExceptionHandeler(Exception exception,WebRequest request)
    {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
