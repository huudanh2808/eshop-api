package hcmus.ktpm.eshop.service.impl;

import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.repository.AdminRepository;
import hcmus.ktpm.eshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(String userName) {
        return adminRepository.findByUserName(userName);
    }
}
