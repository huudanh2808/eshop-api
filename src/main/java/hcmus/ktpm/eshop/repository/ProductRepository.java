package hcmus.ktpm.eshop.repository;

import hcmus.ktpm.eshop.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,String>, QuerydslPredicateExecutor<Product>, ProductRepositoryCustom {

}
