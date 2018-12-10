package hcmus.ktpm.eshop.controller;

import hcmus.ktpm.eshop.dto.ProductDto;
import hcmus.ktpm.eshop.repository.ProductRepository;
import hcmus.ktpm.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductServiceController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @RequestMapping("/product/get-all")
    public List<ProductDto> getAllProduct(@RequestParam(value = "page") Integer page) {
        return productService.loadAllProduct(page);
    }

    @RequestMapping("/product/get-by-type")
    public List<ProductDto> getProductByType(@RequestParam(value = "type-id") Integer typeId, @RequestParam(value = "page") Integer page) {
        return productService.loadAllProductByType(typeId, page);
    }

    @RequestMapping("/product/get-by-manufacturer")
    public List<ProductDto> getProductByManufacturer(@RequestParam(value = "manu-id") Integer manuId, @RequestParam(value = "page") Integer page) {
        return productService.loadAllProductsByManufacturer(manuId, page);
    }

    @RequestMapping("/product/count-all")
    public Long countAllProduct() {
        return productService.countAllProduct();
    }

    @RequestMapping("/product/count-by-type")
    public Long countAllProductByType(@RequestParam(value = "type-id") Integer typeId) {
        return productService.countAllProductByType(typeId);
    }

    @RequestMapping("/product/count-by-manufacturer")
    public Long countAllProductByManufacturer(@RequestParam(value = "manu-id") Integer manuId) {
        return productService.countAllProductByManufacturer(manuId);
    }

    @RequestMapping("/product/count-per-type")
    public List<Map<String, Object>> countAllProductPerType() {
        return productService.countPerType();
    }

    @RequestMapping("/product/get-revenue-per-type")
    public List<Map<String, Object>> getRevenuePerType() {
        return productService.calcuRevenuePerProductType();
    }

    /*Single*/
    @RequestMapping("/product/get-and-check")
    public Map<String, Object> getProductAndIsItOutOfStock(@RequestParam(value = "product-id") String productId) {
        return productService.getProductAndIsItOutOfStock(productId);
    }

    @RequestMapping("/product/get-top-new")
    public List<Map<String, Object>> getTopNewProducts() {
        return productService.getTopNewProducts();
    }

    @RequestMapping("/product/get-top-sale")
    public List<Map<String, Object>> getTopSaleProducts() {
        return productService.getTopSaleProducts();
    }

    @RequestMapping("/product/get-top-viewed")
    public List<Map<String, Object>> getTopViewedProduct() {
        return productService.getTopViewedProducts();
    }

    @RequestMapping("/product/get-detail")
    public ProductDto getProductDetail(@RequestParam(value = "product-id") String productId) {
        return productService.getProductDetail(productId);
    }

    @RequestMapping("/product/test")
    public List<Map<String, Object>> test() {
        return productService.calcuRevenuePerProductType();
    }
}
