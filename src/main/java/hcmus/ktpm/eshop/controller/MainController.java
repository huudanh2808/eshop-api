package hcmus.ktpm.eshop.controller;


import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.dto.ProductDto;
import hcmus.ktpm.eshop.repository.OrderRepository;
import hcmus.ktpm.eshop.service.AdminService;
import hcmus.ktpm.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/admin/login")
    public Admin login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
        return adminService.login(userName, password);
    }

    @RequestMapping("/product/get-all")
    public List<ProductDto> getAllProduct(@RequestParam(value = "page") Integer page) {
        return productService.loadAllProduct(page);
    }

    @RequestMapping("/product/get-by-type")
    public List<ProductDto> getProductByType(@RequestParam(value = "typeid") Integer typeId, @RequestParam(value = "page") Integer page) {
        return productService.loadAllProductByType(typeId, page);
    }

    @RequestMapping("/product/get-by-manufacturer")
    public List<ProductDto> getProductByManufacturer(@RequestParam(value = "manuid") Integer manuId, @RequestParam(value = "page") Integer page) {
        return productService.loadAllProductsByManufacturer(manuId, page);
    }

    @RequestMapping("/product/count-all")
    public Long countAllProduct() {
        return productService.countAllProduct();
    }

    @RequestMapping("/product/count-by-type")
    public Long countAllProductByType(@RequestParam(value = "typeid") Integer typeId) {
        return productService.countAllProductByType(typeId);
    }

    @RequestMapping("/product/count-by-manufacturer")
    public Long countAllProductByManufacturer(@RequestParam(value = "manuid") Integer manuId) {
        return productService.countAllProductByManufacturer(manuId);
    }


    @RequestMapping("/product/count-per-type")
    public List<Map<String, Object>> countAllProductPerType() {
        return productService.countPerType();
    }
}
