package com.meteergin.mediumspringbootsecurity.exception;

/**
 *
 * @author mergin
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super("Could not find employee.");
    }

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id + ".");
    }
}
