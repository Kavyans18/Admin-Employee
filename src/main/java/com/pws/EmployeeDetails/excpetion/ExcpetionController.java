package com.pws.EmployeeDetails.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExcpetionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataAvailableException.class)
    public ResponseEntity<String> handleNoDataAvailableException(NoDataAvailableException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}