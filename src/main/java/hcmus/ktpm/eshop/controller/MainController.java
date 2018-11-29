package hcmus.ktpm.eshop.controller;


import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.dto.Test;
import hcmus.ktpm.eshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @RequestMapping("/get/admin")
    public Admin getAdminByUserName(@RequestParam(value = "username") String userName){
        return adminService.getAdmin(userName);
    }
}
