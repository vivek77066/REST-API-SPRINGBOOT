package com.example.product.entity;

import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    private Double price;
    @ManyToOne
    @JoinColumn(name ="category_id",nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
