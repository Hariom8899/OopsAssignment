package com.expample.service.impl;
import com.expample.repository.EmployeeRepo;

import com.expample.model.Employee;
import com.expample.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> listEmployees(){
        return employeeRepo.findAll();
    }

    public ResponseEntity<Employee> getSpecificEmployee(Long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Employee updateEmployee(Long id, Map<String, String> body){
        Employee current = employeeRepo.findById(id).get();
        current.setDept(body.get("dept"));
        current.setLocation(body.get("location"));
        current.setSalary(Long.parseLong(body.get("salary")));
        employeeRepo.save(current);
        return current;
    }

    public ResponseEntity<Employee> createEmployee(Employee emp){
        try{
            employeeRepo.save(emp);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Employee> delEmployee(Long id){
        try{ Optional<Employee> employee = employeeRepo.findById(id);
            if(employee.isPresent()){
                employeeRepo.deleteById(id);
                return new ResponseEntity<>(employee.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
