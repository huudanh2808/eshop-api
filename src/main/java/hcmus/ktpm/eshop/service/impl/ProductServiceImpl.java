package hcmus.ktpm.eshop.service.impl;

import hcmus.ktpm.eshop.dao.Product;
import hcmus.ktpm.eshop.dto.ProductDto;
import hcmus.ktpm.eshop.mapper.ProductMapper;
import hcmus.ktpm.eshop.repository.ProductRepository;
import hcmus.ktpm.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> loadAllProduct(Integer page) {
        List<Product> products = productRepository.getProductsByPage(page);
        return products.stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> loadAllProductByType(Integer typeId, Integer page) {
        List<Product> products = productRepository.getProductsByTypeId(typeId, page);
        return products.stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> loadAllProductsByManufacturer(Integer manuId, Integer page) {
        List<Product> products = productRepository.getProductsByManufacturerId(manuId, page);
        return products.stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countAllProduct() {
        return productRepository.countAllProduct();
    }

    @Override
    public Long countAllProductByType(Integer typeId) {
        return productRepository.countByTypeId(typeId);
    }

    @Override
    public List<Map<String, Object>> countPerType() {
        return productRepository.countPerType();
    }

    @Override
    public Long countAllProductByManufacturer(Integer manuId) {
        return productRepository.countByManufacturerId(manuId);
    }
}
