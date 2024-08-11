package com.mediphore.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidStrategyException extends RuntimeException {

  public InvalidStrategyException(String message) {
    super(message);
  }
}
