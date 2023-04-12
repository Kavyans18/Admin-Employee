package com.pws.EmployeeDetails.controller;

import com.pws.EmployeeDetails.entity.Employee;
import com.pws.EmployeeDetails.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService service;

    @Operation(summary = "Save")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "saved Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @PostMapping("/save/{id}")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee, @PathVariable int id) {
        logger.info("From class name :{}, Accessing saveEmployee method to save Employee details",
                this.getClass().getSimpleName());
        service.saveEmployee(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Operation(summary = "Update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        logger.info("From class name :{}, Accessing updateEmployee method to update employee details",
                this.getClass().getSimpleName());
        service.updateEmployee(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        logger.info("From class name :{}, Accessing getEmployeeById method to fetch employee details using Employee Id",
                this.getClass().getSimpleName());
        Employee emp = service.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        logger.info("From class name :{}, Accessing getAllEmployee method to fetch all the employee details available in the database",
                this.getClass().getSimpleName());
        List<Employee> employees = service.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(int id) {
        logger.info("From class name :{}, Accessing deleteEmployee method to delete employee details",
                this.getClass().getSimpleName());
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping("/page/{page}/{obj}")
    public ResponseEntity<Page<Employee>> findEmployeeWithPagination(@PathVariable int page, @PathVariable int obj) {
        logger.info("From class name :{}, Accessing pagination method to get employee details in specified number of pages",
                this.getClass().getSimpleName());
        Page<Employee> employee = service.findEmployeeWithPagination(page, obj);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
