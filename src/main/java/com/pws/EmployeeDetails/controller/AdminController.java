package com.pws.EmployeeDetails.controller;

import com.pws.EmployeeDetails.entity.Admin;
import com.pws.EmployeeDetails.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService service;

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
    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        logger.info("From class name :{}, Accessing saveAdmin method to save Admin entity",
                this.getClass().getSimpleName());
        service.saveAdmin(admin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @Operation(summary = "Update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access Denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable int id) {
        logger.info("From class name :{}, Accessing updateAdmin method to update Admin details",
                this.getClass().getSimpleName());
        service.updateAdmin(admin, id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content),
            @ApiResponse(responseCode = "404", description = "Access Denied",
            content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content)})
    @GetMapping("/id/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        logger.info("From class name :{}, Accessing getAdminById method to fetch Admin details using Admin Id",
                this.getClass().getSimpleName());
        Admin ad = service.getAdminById(id);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access Denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        logger.info("From Class name :{}, Accessing getAllAdmin method to fetch all the Admin details present in the database",
                this.getClass().getSimpleName());
        List<Admin> admin = service.getAllAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }


    @Operation(summary = "Delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access Denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable int id) {
        logger.info("From class name :{}, Accessing deleteAdmin method to delete Admin details",
                this.getClass().getSimpleName());
        service.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access Denied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping("/page/{offset}/{page}")
    public ResponseEntity<Page<Admin>> findAdminWithPagination(@PathVariable int page, @PathVariable int obj) {
        logger.info("From class name :{}, Accessing pagination method to fetch Admin details in pages",
                this.getClass().getSimpleName());
        Page<Admin> admin = service.findAdminWithPagination(page, obj);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}
