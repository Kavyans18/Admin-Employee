package com.pws.EmployeeDetails.serviceimp;

import com.pws.EmployeeDetails.entity.Admin;
import com.pws.EmployeeDetails.entity.Employee;
import com.pws.EmployeeDetails.excpetion.IdNotFoundException;
import com.pws.EmployeeDetails.excpetion.NoDataAvailableException;
import com.pws.EmployeeDetails.repository.AdminRepository;
import com.pws.EmployeeDetails.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {

    private final AdminRepository repository;

    @Override
    public Admin saveAdmin(Admin admin) {
        repository.save(admin);
        return null;
    }

    @Override
    public Admin updateAdmin(Admin admin, int id) {
        Optional<Admin> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Admin Id");
        }
        Admin ad = optional.get();
        ad.setName(admin.getName());
        ad.setEmail(admin.getEmail());
        ad.setPassword(admin.getPassword());
        ad.setPhoneNumber(admin.getPhoneNumber());
        repository.save(ad);
        return ad;
    }

    @Override
    public Admin getAdminById(int id) {
        Optional<Admin> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Admin Id");
        }
        return optional.get();
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admin = repository.findAll();
        if (admin == null) {
            throw new NoDataAvailableException("Data base is empty");
        }
        return admin;
    }

    @Override
    public void deleteAdmin(int id) {
        Optional<Admin> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid admin Id");
        }
        repository.delete(optional.get());
    }

    public Page<Admin> findAdminWithPagination(int page, int obj) {
        Page<Admin> admin = repository.findAll(PageRequest.of(page, obj));
        return admin;
    }
}
