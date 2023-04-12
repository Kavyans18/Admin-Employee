package com.pws.EmployeeDetails.service;

import com.pws.EmployeeDetails.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void deleteEmployee(int id);

    Page<Employee> findEmployeeWithPagination(int page, int obj);
}
