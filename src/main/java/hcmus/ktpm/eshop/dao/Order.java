package hcmus.ktpm.eshop.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "id_order")
    private Integer id;

    @Column(name = "time_place")
    private LocalDate timePlace;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "email")
    private Client client;
}
