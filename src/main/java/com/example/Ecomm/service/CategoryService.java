package com.example.Ecomm.service;

import com.example.Ecomm.model.Category;

import java.util.List;

public interface CategoryService {
    public String addCategory(Category category);
    public List<Category> returnCategory();
    String deleteCategory(Long categoryId);
    public Category updateCategory(Category category, Long categoryId);
}
