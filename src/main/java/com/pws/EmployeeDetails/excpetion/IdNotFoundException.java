package com.pws.EmployeeDetails.excpetion;

public class IdNotFoundException extends RuntimeException{
    String message = "INVALID ID";

    public IdNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
