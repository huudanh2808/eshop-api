package hcmus.ktpm.eshop.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import hcmus.ktpm.eshop.config.DataConfig;
import hcmus.ktpm.eshop.dao.Product;
import hcmus.ktpm.eshop.dao.QProduct;
import hcmus.ktpm.eshop.repository.ProductRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getProductsByPage(Integer page) {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product)
                .from(QProduct.product)
                .limit(DataConfig.PRODUCT_PER_PAGE)
                .offset(page)
                .fetch();
    }

    @Override
    public Long countAllProduct() {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product.count())
                .from(QProduct.product)
                .fetchOne();
    }

    @Override
    public Long countByTypeId(Integer typeId) {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product.count())
                .from(QProduct.product)
                .where(QProduct.product.classProduct.id.eq(typeId))
                .fetchOne();
    }

    @Override
    public Long countByManufacturerId(Integer manuId) {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product.count())
                .from(QProduct.product)
                .where(QProduct.product.manufacturer.id.eq(manuId))
                .fetchOne();
    }

    @Override
    public List<Map<String, Object>> countPerType() {
        List<Map<String, Object>> resultMap = new ArrayList<>();
        List<Tuple> queryResult = new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product.classProduct.name, QProduct.product.classProduct.count())
                .from(QProduct.product)
                .groupBy(QProduct.product.classProduct)
                .fetch();
        queryResult.forEach(tuple -> {
            Map<String, Object> oneRow = new HashMap<>();
            oneRow.put("name", tuple.get(QProduct.product.classProduct.name));
            oneRow.put("quantity", tuple.get(QProduct.product.classProduct.count()));
            resultMap.add(oneRow);
        });
        return resultMap;
    }

    @Override
    public List<Product> getProductsByTypeId(Integer typeId, Integer page) {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product)
                .from(QProduct.product)
                .where(QProduct.product.classProduct.id.eq(typeId))
                .limit(DataConfig.PRODUCT_PER_PAGE)
                .offset(page)
                .fetch();
    }

    @Override
    public List<Product> getProductsByManufacturerId(Integer manuId, Integer page) {
        return new JPAQuery<QProduct>(entityManager)
                .select(QProduct.product)
                .from(QProduct.product)
                .where(QProduct.product.manufacturer.id.eq(manuId))
                .limit(DataConfig.PRODUCT_PER_PAGE)
                .offset(page)
                .fetch();
    }


}
