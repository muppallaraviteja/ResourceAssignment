package com.mediphore.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class ResourceNotAvailableException extends RuntimeException {

  public ResourceNotAvailableException(String message){
    super(message);
  }


}
