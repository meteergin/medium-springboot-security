package com.meteergin.mediumspringbootsecurity.advice;

import com.meteergin.mediumspringbootsecurity.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author mergin
 */
@ControllerAdvice
public class EmployeeAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }
}
