package com.rsfrancisco.course.resources.exceptions;

import com.rsfrancisco.course.services.exceptions.DatabaseException;
import com.rsfrancisco.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String errorMessage = "Resource not found";
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(statusCode.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(statusCode).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException exception, HttpServletRequest request) {
        String errorMessage = "Database error";
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(statusCode.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(statusCode).body(error);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<StandardError> invalidParameter(InvalidParameterException exception, HttpServletRequest request) {
        String errorMsg = "invalid parameter or parameter is missing";
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(statusCode.value(), errorMsg, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(statusCode).body(error);
    }
}
