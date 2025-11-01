package com.example.Ecomm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Data // bundles getter and setter @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private long categoryId;
    @NotBlank
    @Size(min = 5,message="The length should be more than 5")
    private String categoryName;

//    public Category() {
//    }
//
//    public Category(String categoryName, int categoryId) {
//        this.categoryName = categoryName;
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//
//        this.categoryName = categoryName;
//    }
//
//    public long getCategoryId() {
//
//        return categoryId;
//    }
//
//    public void setCategoryId(long categoryId) {
//
//        this.categoryId = categoryId;
//    }


}
