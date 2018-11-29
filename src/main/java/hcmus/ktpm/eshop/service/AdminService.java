package hcmus.ktpm.eshop.service;

import hcmus.ktpm.eshop.dao.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin getAdmin(String userName);
}
