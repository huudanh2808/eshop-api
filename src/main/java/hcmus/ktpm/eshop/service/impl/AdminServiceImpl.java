package hcmus.ktpm.eshop.service.impl;

import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.repository.AdminRepository;
import hcmus.ktpm.eshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public Admin login(String userName, String password) {
        return adminRepository.getAdmin(userName, password);
    }
}
