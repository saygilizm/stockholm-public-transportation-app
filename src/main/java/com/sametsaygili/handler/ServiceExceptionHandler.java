package com.sametsaygili.handler;

import com.sametsaygili.handler.error.ApiErrorResponse;
import com.sametsaygili.handler.error.LineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

  @ExceptionHandler(LineNotFoundException.class)
  public ResponseEntity<ApiErrorResponse> handleApiException(LineNotFoundException ex) {

    ApiErrorResponse response =
        new ApiErrorResponse("error-0001", "No line found with ID " + ex.getId());

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}

