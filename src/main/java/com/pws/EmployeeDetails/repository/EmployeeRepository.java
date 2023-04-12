package com.pws.EmployeeDetails.repository;

import com.pws.EmployeeDetails.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
