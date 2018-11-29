package hcmus.ktpm.eshop.repository;

import hcmus.ktpm.eshop.dao.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>, QuerydslPredicateExecutor<Admin>, AdminRepositoryCustom {

}
