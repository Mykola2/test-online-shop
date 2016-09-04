package ua.nickoh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by nickoh on 8/31/16.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;


    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
