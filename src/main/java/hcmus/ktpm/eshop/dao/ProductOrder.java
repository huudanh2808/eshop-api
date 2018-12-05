package hcmus.ktpm.eshop.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @Column(name = "id_order")
    private Integer oderId;

    @Id
    @Column(name = "id_order")
    private String productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Integer price;
}
