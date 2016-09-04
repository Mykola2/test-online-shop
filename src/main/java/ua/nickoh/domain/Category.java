package ua.nickoh.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nickoh on 8/31/16.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
