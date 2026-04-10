package com.example.lab2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Order() {}

    public Long getId() { return  id; }

    public  String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public  Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public  User getUser() { return user; }

    public void setUser(User user) { this.user = user; }




}
