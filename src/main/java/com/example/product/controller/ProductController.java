package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Product Rest Api Crud operation",
        description = "crud operation"
)
@RestController
@RequestMapping("/api/products")
public class ProductController {

private ProductService productService;

 @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
@PostMapping
public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
     return new ResponseEntity<>(productService.createProduct(productDTO),HttpStatus.CREATED);
}

@Operation(
        summary = "Fatch all products",
        description = "Rest api to fatch all product"
)
@GetMapping
    public List<ProductDTO> getAllProducts(){
     return productService.getAllProducts();
}
@GetMapping("/{id}")
public ProductDTO getProductbyId(@PathVariable Long id){
     return  productService.getProductbyId(id);
}

@PutMapping("/{id}")
public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
return productService.updateProduct(id,productDTO);
}

@DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
     return productService.deleteProductbyId(id);
}
}
