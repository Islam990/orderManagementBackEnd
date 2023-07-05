package com.islamGad.orderManagementBackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class OrderPojo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String date;

    @OneToMany( mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> productList;

    public OrderPojo() {
        this.date = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
