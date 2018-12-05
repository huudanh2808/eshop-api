package hcmus.ktpm.eshop.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @Column(name = "id_manufacturer")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

}
