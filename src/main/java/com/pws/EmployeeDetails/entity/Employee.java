package com.pws.EmployeeDetails.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number", nullable = false, unique = true)
    @Pattern(regexp = "[1-9]{10}", message = "Phone Number must be 10 digits")
    private String phoneNumber;
    @Column(name = "date_of_joining")
    private String dateOfJoining;
    @Column(name = "date_of_reliving")
    private String dateOfReliving;
    @ManyToOne
    @JoinColumn
    Admin admin;
}
