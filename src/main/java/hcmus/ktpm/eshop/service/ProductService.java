package hcmus.ktpm.eshop.service;


import hcmus.ktpm.eshop.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDto> loadAllProduct(Integer page);

    List<ProductDto> loadAllProductByType(Integer typeId, Integer page);

    List<ProductDto> loadAllProductsByManufacturer(Integer manuId, Integer page);

    Long countAllProduct();

    Long countAllProductByType(Integer typeId);

    List<Map<String, Object>> countPerType();

    Long countAllProductByManufacturer(Integer manuId);

    List<Map<String,Object>> calcuRevenuePerProductType();

    Map<String,Object> getProductAndIsItOutOfStock(String productId);

    List<Map<String,Object>> getTopNewProducts();

    List<Map<String,Object>> getTopSaleProducts();

    List<Map<String,Object>> getTopViewedProducts();

    ProductDto getProductDetail(String productId);

    List<ProductDto> getSample();

}
