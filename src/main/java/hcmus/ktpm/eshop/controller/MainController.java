package hcmus.ktpm.eshop.controller;


import hcmus.ktpm.eshop.dto.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public Test getTest(){
        return new Test("Danh",21);
    }
}
