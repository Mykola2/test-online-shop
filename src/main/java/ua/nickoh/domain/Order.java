package ua.nickoh.domain;

import ua.nickoh.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nickoh on 8/31/16.
 */

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_order;

    @Column(name = "date_created")
    private Date date_created;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "order_number")
    private Integer order_number;

    @Column(name = "total_price")
    private Integer total_price;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Order(Date date_created, Integer amount, Integer order_number, Integer total_price, User user) {
        this.date_created = date_created;
        this.amount = amount;
        this.order_number = order_number;
        this.total_price = total_price;
        this.user = user;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }
}
