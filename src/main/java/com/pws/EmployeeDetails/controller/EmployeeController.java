package com.pws.EmployeeDetails.controller;

import com.pws.EmployeeDetails.entity.Employee;
import com.pws.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
        service.updateEmployee(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee emp = service.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = service.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(int id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{page}/{obj}")
    public ResponseEntity<Page<Employee>> findEmployeeWithPagination(@PathVariable int page, @PathVariable int obj) {
        Page<Employee> employee = service.findEmployeeWithPagination(page, obj);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
