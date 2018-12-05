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
}
