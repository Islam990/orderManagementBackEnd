package com.islamGad.orderManagementBackEnd.DTO;

import com.islamGad.orderManagementBackEnd.models.Product;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private int id;
    private String date;
    private List<ProductDTO> productList;

    public OrderDto() {
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

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
