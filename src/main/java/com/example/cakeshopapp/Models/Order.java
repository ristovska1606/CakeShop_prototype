package com.example.cakeshopapp.Models;

import com.example.cakeshopapp.Models.enums.OrderStatus;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "allOrders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long order_id;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    private String cartNumber;
    private String dateAndTime;
    private String address;
    private String note;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    public Order(Cart cart, String cartNumber, String dateAndTime, String address, String note) {
        this.cart = cart;
        this.cartNumber = cartNumber;
        this.dateAndTime = dateAndTime;
        this.note = note;
        this.address=address;
        this.status = OrderStatus.IN_PROGRESS;
    }

    public Order() {
    }
}
