package com.example.product.dto;

import com.example.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "Category",
        description = "it hold category information along with Products"
)
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;

    public Long getId() {
        return id;
    }


    public CategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public CategoryDTO(List<ProductDTO> products, String name, Long id) {
        this.products = products;
        this.name = name;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
