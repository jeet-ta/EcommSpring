package com.example.Ecomm.repositories;

import com.example.Ecomm.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // Can create customs methods without implementation with the help off JPA, if the convention is followed
    Category findByCategoryName(Category category);
}
