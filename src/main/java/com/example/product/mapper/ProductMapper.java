package com.example.product.mapper;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;

public class ProductMapper {

public static Product toProductEntity(ProductDTO productDTO, Category category){
    Product product=new Product();
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setCategory(category);

    return product;
}

public static ProductDTO toProductDTO(Product product){
    ProductDTO productDTO=new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setPrice(product.getPrice());
    productDTO.setDescription(product.getDescription());

    if (product.getCategory() != null) {
        productDTO.setcategoryId(product.getCategory().getId());
    }
    return productDTO;
}
}
