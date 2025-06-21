package com.example.product.service;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.exception.CategoryAlreadyExistException;
import com.example.product.mapper.CategoryMapper;
import com.example.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
   private CategoryRepository categoryRepository;

public CategoryDTO createCategory( CategoryDTO categoryDTO){

    Optional<Category> optionalCategory =categoryRepository.findByName(categoryDTO.getName());
    if(optionalCategory.isPresent()){
        throw  new CategoryAlreadyExistException("Category "+categoryDTO.getName()+" already present");
    }
    Category category= CategoryMapper.toCategoryEntity(categoryDTO);
              category=categoryRepository.save(category);
              return CategoryMapper.toCategoryDTO(category);
}

public List<CategoryDTO> getAllCategories(){
    return  categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();

}

public CategoryDTO getCategorybyId(Long id){
    Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
    return CategoryMapper.toCategoryDTO(category);
}

public String deleteCatrgory(Long id){
    categoryRepository.deleteById(id);
    return "category" +id+"delete category";
}
}
