package com.expample.repository;

import com.expample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Long>{
}
