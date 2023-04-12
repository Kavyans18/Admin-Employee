package com.pws.EmployeeDetails.serviceimp;

import com.pws.EmployeeDetails.entity.Employee;
import com.pws.EmployeeDetails.excpetion.IdNotFoundException;
import com.pws.EmployeeDetails.repository.EmployeeRepository;
import com.pws.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository repository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee ID");
        }
        Employee emp = optional.get();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.setPassword(employee.getPassword());
        emp.setDateOfReliving(employee.getDateOfReliving());
        repository.save(emp);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee Id");
        }
        return optional.get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> emp = repository.findAll();
        return emp;
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee Id");
        }
        repository.delete(optional.get());

    }

    @Override
    public Page<Employee> findEmployeeWithPagination(int page, int obj) {
        Page<Employee> employee = repository.findAll(PageRequest.of(page, obj));
        return employee;
    }
}
