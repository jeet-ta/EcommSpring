package com.example.Ecomm.service;

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

    private List<Category> categoryList = new ArrayList<>();
    private long nextID  =  1L;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String addCategory(Category category) {
       // category.setCategoryId(nextID++);
        categoryRepository.save(category);
        return "Category added successfully";
    }

    @Override
    public List<Category> returnCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Optional<Category> categories = categoryRepository.findById(categoryId);

            Category category = categoryList.stream()
                    .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

            categoryList.remove(category);
            return "Category with categoryId: " + categoryId + " deleted successfully !!";
        }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Optional<Category> categories = categoryRepository.findById(categoryId);

        Optional<Category> optionalCategory = categoryList.stream()
                .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
                .findFirst();

        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}

