package com.example.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Product",
        description = "it hold product information along with category"
)
public class ProductDTO {


    private Long id;
    private String name;
    private String Description;
    private Double price;
    private Long categoryId;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public ProductDTO(Long id, String name, String description, Double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.Description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public Long getcategoryId() {
        return categoryId;
    }

    public void setcategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
