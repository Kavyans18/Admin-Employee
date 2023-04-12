package com.pws.EmployeeDetails.controller;

import com.pws.EmployeeDetails.entity.Admin;
import com.pws.EmployeeDetails.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        service.saveAdmin(admin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
     public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable int id) {
        service.updateAdmin(admin,id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
     }

     @GetMapping("/id/{id}")
     public ResponseEntity<Admin> getAdminById(@PathVariable int id){
        Admin ad = service.getAdminById(id);
        return new ResponseEntity<>(ad, HttpStatus.OK);
     }

     @GetMapping("/all")
     public ResponseEntity<List<Admin>> getAllAdmin(){
      List<Admin> admin = service.getAllAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Admin> deleteAdmin(@PathVariable int id){
        service.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
     }

     @GetMapping("/page/{offset}/{page}")
     public ResponseEntity<Page<Admin>> findAdminWithPagination(@PathVariable int page, @PathVariable int obj){
        Page<Admin> admin = service.findAdminWithPagination(page, obj);
        return new ResponseEntity<>(admin, HttpStatus.OK);
     }
}
