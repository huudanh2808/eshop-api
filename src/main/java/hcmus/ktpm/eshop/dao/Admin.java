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
@Table(name = "`admin`")
public class Admin {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;
}
