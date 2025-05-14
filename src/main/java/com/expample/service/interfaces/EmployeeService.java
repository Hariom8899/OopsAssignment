package com.expample.service.interfaces;

import com.expample.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> listEmployees();
    ResponseEntity<Employee> createEmployee(Employee emp);
    ResponseEntity<Employee> delEmployee(Long id);
    Employee updateEmployee(Long id, Map<String, String> body);
    ResponseEntity<Employee> getSpecificEmployee(Long id);
}
