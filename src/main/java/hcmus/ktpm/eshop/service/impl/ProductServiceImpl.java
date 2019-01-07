package hcmus.ktpm.eshop.service.impl;

import hcmus.ktpm.eshop.constant.ProductConstant;
import hcmus.ktpm.eshop.dao.Product;
import hcmus.ktpm.eshop.dao.QProduct;
import hcmus.ktpm.eshop.dto.ProductDto;
import hcmus.ktpm.eshop.mapper.ProductMapper;
import hcmus.ktpm.eshop.repository.ClassProductRepository;
import hcmus.ktpm.eshop.repository.ProductRepository;
import hcmus.ktpm.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Throwable.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClassProductRepository classProductRepository;

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

    @Override
    public List<Map<String, Object>> calcuRevenuePerProductType() {
        return productRepository.getRevenuePerProductType();
    }

    @Override
    public Map<String, Object> getProductAndIsItOutOfStock(String productId) {
        Map<String, Object> result = new HashMap<>();
        Product product = productRepository.getOne(productId);
        result.put(ProductConstant.PRODUCT_KEY, ProductMapper.toProductDto(product));
        result.put(ProductConstant.PRODUCT_OUT_STOCK_KEY, product.getInStock() <= 0);
        return result;
    }

    @Override
    public List<ProductDto> getTopNewProducts() {
        return productRepository.getTopNewProducts().stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getTopSaleProducts() {
        return productRepository.getTopSaleProducts().stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getTopViewedProducts() {
        return productRepository.getTopViewedProduct().stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductDetail(String productId) {
        Optional<Product> product = productRepository.findOne(QProduct.product.id.eq(productId));
        if (product.isPresent()){
            return  ProductMapper.toProductDto(productRepository.getOne(productId));
        }
        else {
            return null;
        }
    }

    @Override
    public List<ProductDto> getSample() {
        List<Product> products = productRepository.getSampleProduct();
        return products.stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }
}
