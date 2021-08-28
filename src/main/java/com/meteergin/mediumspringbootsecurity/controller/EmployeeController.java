package com.meteergin.mediumspringbootsecurity.controller;

import com.meteergin.mediumspringbootsecurity.entity.Employee;
import com.meteergin.mediumspringbootsecurity.exception.EmployeeNotFoundException;
import com.meteergin.mediumspringbootsecurity.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mergin
 */
@RestController
@RequestMapping(path = "/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(employeeService
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id)), HttpStatus.OK);
    }
}
