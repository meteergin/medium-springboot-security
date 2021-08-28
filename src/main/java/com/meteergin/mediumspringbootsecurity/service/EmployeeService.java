package com.meteergin.mediumspringbootsecurity.service;

import com.meteergin.mediumspringbootsecurity.entity.Employee;
import com.meteergin.mediumspringbootsecurity.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author mergin
 */
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> saveAll(List<Employee> employeeList) {
        return employeeRepository.saveAll(employeeList);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}
