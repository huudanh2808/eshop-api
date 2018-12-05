package hcmus.ktpm.eshop.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product_order")
public class ProductOrder implements Serializable {
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer oderId;

    @Id
    @Column(name = "id_product", nullable = false)
    private String productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Integer price;
}
