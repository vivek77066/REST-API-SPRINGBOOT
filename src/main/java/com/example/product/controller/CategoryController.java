package com.example.product.controller;

import com.example.product.dto.CategoryDTO;
import com.example.product.service.CategoryService;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Category Rest Api Crud operation",
        description = "crud operation"
)

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

@GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();

    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
    return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED) ;

}
  @GetMapping("/{id}")
    public CategoryDTO getCategorybyId(@PathVariable Long id){
        return  categoryService.getCategorybyId(id);
  }
  @DeleteMapping("/{id}")
 public String deleteCatrgory(@PathVariable Long id){
         return categoryService.deleteCatrgory(id);
 }
}

