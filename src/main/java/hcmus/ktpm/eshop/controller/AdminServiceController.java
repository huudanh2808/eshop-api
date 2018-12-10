package hcmus.ktpm.eshop.controller;

import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminServiceController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/login")
    public Admin login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
        return adminService.login(userName, password);
    }

}
