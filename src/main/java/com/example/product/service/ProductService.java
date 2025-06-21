package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.exception.CategoryNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
@Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO){

    Category category=categoryRepository.findById(productDTO.getcategoryId())
            .orElseThrow(()->new CategoryNotFoundException("Category id "+productDTO.getcategoryId()+"not found"));
    Product product= ProductMapper.toProductEntity(productDTO,category);
     product=productRepository.save(product);
     return ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
   return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }


    public ProductDTO getProductbyId(Long id){
    Product product =productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
     return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        Product product =productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
       Category category =categoryRepository.findById(productDTO.getcategoryId()).orElseThrow(()->new RuntimeException("product not found"));
       product.setName(productDTO.getName());
       product.setDescription(productDTO.getDescription());
       product.setPrice(productDTO.getPrice());
       product.setCategory(category);

       productRepository.save(product);
       return ProductMapper.toProductDTO(product);

    }

    public String deleteProductbyId(Long id){
    productRepository.deleteById(id);
    return "delete product"+id+"delete";
    }

}
