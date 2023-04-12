package com.pws.EmployeeDetails.entity;

import lombok.Data;

import javax.persistence.*;
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
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number", nullable = false, unique = true)
    private long phoneNumber;
    @Column(name = "date_of_joining")
    private String dateOfJoining;
    @Column(name = "date_of_reliving")
    private String dateOfReliving;
}
