package hcmus.ktpm.eshop.repository;

import hcmus.ktpm.eshop.dao.ClassProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClassProductRepository extends JpaRepository<ClassProduct,Integer>, QuerydslPredicateExecutor<ClassProduct> {
}
