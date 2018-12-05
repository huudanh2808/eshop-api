package hcmus.ktpm.eshop.service;

import hcmus.ktpm.eshop.dao.Admin;

public interface AdminService {
    Admin login(String userName, String password);
}
