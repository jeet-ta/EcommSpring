package com.example.Ecomm.controller;

import com.example.Ecomm.model.Category;
import com.example.Ecomm.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //@GetMapping(".category")
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public ResponseEntity<List> returnCategory() {
        List<Category> categories = categoryService.returnCategory();
        return new ResponseEntity<>(categories,HttpStatus.FOUND);
    }

    //@PostMapping(".category")
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public ResponseEntity<String> addCategory(@Valid @RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category added successfully",HttpStatus.CREATED);
    }

    //@DeleteMapping(".category/{categoryId}")
    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.DELETE)
        public ResponseEntity<String> deleteCategory (@Valid @PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    //@PutMapping(".public.categories/{categoryId}")
    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,
                                                 @PathVariable Long categoryId) {

        try{
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with category id: " + categoryId + " updated successfully", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
