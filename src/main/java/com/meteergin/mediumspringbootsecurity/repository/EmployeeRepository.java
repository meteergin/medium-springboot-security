package com.meteergin.mediumspringbootsecurity.repository;

import com.meteergin.mediumspringbootsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mergin
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
