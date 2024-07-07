package com.testdb.testDB.controller;

import com.testdb.testDB.model.Category;
import com.testdb.testDB.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return ResponseEntity.ok(category);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            result.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(". ");
            });
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody Category categoryDetails, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            result.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(". ");
            });
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCategory() {
        categoryService.deleteAllCategory();
        String message = "All transactions deleted successfully";
        return ResponseEntity.ok(message);
    }
}
