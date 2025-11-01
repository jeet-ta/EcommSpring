package com.example.Ecomm.service;

import com.example.Ecomm.exception.ResourceNotFoundException;
import com.example.Ecomm.model.Category;
import com.example.Ecomm.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

   // private List<Category> categoryList = new ArrayList<>();
    private long nextID  =  1L;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String addCategory(Category category) {
       // category.setCategoryId(nextID++);
        Category savedCategory = categoryRepository.findByCategoryName(category);
        categoryRepository.save(category);
        return "Category added successfully";
    }

    @Override
    public List<Category> returnCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public String deleteCategory(Long categoryId) {
       //List<Category> categoryList = categoryRepository.findAll();
      // Optional<Category> categories = categoryRepository.findById(categoryId);

        Category savedCategory =  categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Catergory","CategoryId ",categoryId));
        categoryRepository.delete(savedCategory);

        return "Category with categoryId: " + categoryId + " deleted successfully !!";

//            Category category = categoryList.stream()
//                    .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
//                    .findFirst()
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
//
//            categoryList.remove(category);
//            return "Category with categoryId: " + categoryId + " deleted successfully !!";
        }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
       // List<Category> categoryList = categoryRepository.findAll();
        // Optional<Category> categories = categoryRepository.findById(categoryId);
        Category savedCategory =  categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category",category.getCategoryName(),categoryId));
        category.setCategoryId(categoryId);

        savedCategory.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;


//        Optional<Category> optionalCategory = Optional.ofNullable(categoryList.stream()
//                .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
//                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found")));

//        if(categories.isPresent()) {
//            Category existingCategory = categories.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            return existingCategory;
//        }
    }
}

