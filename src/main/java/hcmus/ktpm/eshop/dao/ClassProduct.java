package hcmus.ktpm.eshop.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "class_product")
public class ClassProduct {

    @Id
    @Column(name = "id_class")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "classProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}
