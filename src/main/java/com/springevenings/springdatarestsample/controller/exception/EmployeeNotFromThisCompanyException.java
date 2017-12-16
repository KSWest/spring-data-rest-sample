package com.springevenings.springdatarestsample.controller.exception;

public class EmployeeNotFromThisCompanyException extends RuntimeException {

    public EmployeeNotFromThisCompanyException(String message) {
        super(message);
    }

    public EmployeeNotFromThisCompanyException() {
    }
}
