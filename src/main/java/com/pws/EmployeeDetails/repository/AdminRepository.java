package com.pws.EmployeeDetails.repository;

import com.pws.EmployeeDetails.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
