package com.rsfrancisco.course.resources.exceptions;

import com.rsfrancisco.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String errorMessage = "Resource not found";
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(statusCode.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(statusCode).body(error);
    }
}
