package hcmus.ktpm.eshop.service;

import hcmus.ktpm.eshop.dao.Admin;

import java.util.List;

public interface AdminService {
    Admin login(String userName, String password);
}
