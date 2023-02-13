package com.outdoor.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiRequestHandler {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiException> handleApiRequestException(ApiException e){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException,apiException.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiException> handleApiRequestException(NotFoundException e){
        ApiException apiException = new ApiException(e.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException,apiException.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiException> handleBadRequestException(BadRequestException e){
        ApiException apiException = new ApiException(e.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException,apiException.getHttpStatus());
    }
}
