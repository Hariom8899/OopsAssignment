package com.expample.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.expample.model.Employee;
import com.expample.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allEmployee")
   List<Employee> listAllEmployees(){
       return employeeService.listEmployees();
   }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getSpecificEmployee(@PathVariable Long id){
       return employeeService.getSpecificEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Map<String, String> body){
       return employeeService.updateEmployee(id, body);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
       return employeeService.createEmployee(emp);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Employee> delEmployee(@PathVariable Long id){
      return employeeService.delEmployee(id);
    }

}
