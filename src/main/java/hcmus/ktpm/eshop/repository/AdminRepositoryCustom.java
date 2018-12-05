package hcmus.ktpm.eshop.repository;

import hcmus.ktpm.eshop.dao.Admin;

public interface AdminRepositoryCustom {
    Admin getAdmin(String userName, String password);
}
