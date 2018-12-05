package hcmus.ktpm.eshop.dao;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id_product", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "sell_amount")
    private Integer sellAmount;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "rating_count")
    private Integer ratingCount;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "in_stock")
    private Integer inStock;

    @Column(name = "import_price")
    private Integer importPrice;

    @ManyToOne
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassProduct classProduct;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="product_order", joinColumns={@JoinColumn(referencedColumnName="id_product")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="id_order")})
    private List<Order> orders;
}
