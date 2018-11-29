package hcmus.ktpm.eshop.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import hcmus.ktpm.eshop.dao.Admin;
import hcmus.ktpm.eshop.dao.QAdmin;
import hcmus.ktpm.eshop.repository.AdminRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdminRepositoryCustomImpl implements AdminRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Admin findByUserName(String userName) {
        return new JPAQuery<Admin>(entityManager)
                .select(QAdmin.admin)
                .from(QAdmin.admin)
                .where(QAdmin.admin.userName.eq(userName))
                .fetchOne();
    }
}
