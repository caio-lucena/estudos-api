package com.udemy.backend.estudos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.InputMismatchException;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    private String description;

    public Product (){

    }

    public Product (String nameInit, Integer amountInit, Double priceInit){
        name = nameInit;

        if (priceInit > 0){
            price = priceInit;
        }
        else {
            throw new InputMismatchException("É preciso informar um preço maior que R$ 0,00");
        }

        if (amountInit > 0) {
            amount = amountInit;
        }
        else{
            throw new InputMismatchException("É preciso informar um valor maior que zero para quantidade");
        }
    }

    public Product (String nameInit, Integer amountInit, Double priceInit, String descriptionInit){
        name = nameInit;

        if (priceInit > 0){
            price = priceInit;
        }
        else {
            throw new InputMismatchException("É preciso informar um preço maior que R$ 0,00");
        }

        if (amountInit > 0) {
            amount = amountInit;
        }
        else{
            throw new InputMismatchException("É preciso informar um valor maior que zero para quantidade");
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
