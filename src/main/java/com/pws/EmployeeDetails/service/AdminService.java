package com.pws.EmployeeDetails.service;

import com.pws.EmployeeDetails.entity.Admin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    Admin updateAdmin(Admin admin, int id);

    Admin getAdminById(int id);

    List<Admin> getAllAdmin();

    void deleteAdmin(int id);

    Page<Admin> findAdminWithPagination(int page, int obj);
}
