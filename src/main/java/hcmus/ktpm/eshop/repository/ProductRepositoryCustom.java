package hcmus.ktpm.eshop.repository;

import hcmus.ktpm.eshop.dao.ClassProduct;
import hcmus.ktpm.eshop.dao.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepositoryCustom {

    Long countAllProduct();

    Long countByTypeId(Integer typeId);

    Long countByManufacturerId(Integer manuId);

    List<Map<String,Object>> countPerType();

    List<Product> getProductsByPage(Integer page);

    List<Product> getProductsByTypeId(Integer typeId, Integer page);

    List<Product> getProductsByManufacturerId(Integer manuId, Integer page);

    List<Map<String,Object>> getRevenuePerProductType();

    List<Product> getTopNewProducts();

    List<Product> getTopSaleProducts();

    List<Product> getTopViewedProduct();
}
