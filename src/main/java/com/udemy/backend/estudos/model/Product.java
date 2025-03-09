package com.udemy.backend.estudos.model;

import java.util.InputMismatchException;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;

    public Product (){

    }

    public Product (String nameInit, Double priceInit){
        name = nameInit;

        if (priceInit > 0){
            price = priceInit;
        }
        else {
            throw new InputMismatchException("É preciso informar um preço maior que R$ 0,00");
        }
    }

    public Product (String nameInit, Double priceInit, String descriptionInit){
        name = nameInit;

        if (priceInit > 0){
            price = priceInit;
        }
        else {
            throw new InputMismatchException("É preciso informar um preço maior que R$ 0,00");
        }
        description = descriptionInit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", description = '" + description + '\'' +
                ']';
    }
}
