package com.testdb.testDB.service;

import com.testdb.testDB.model.Category;
import com.testdb.testDB.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategory() {
        List<Category> list = categoryRepo.findAll();
        return list;
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setUser_id(categoryDetails.getUser_id());
        category.setCategory_name(categoryDetails.getCategory_name());
        category.setDescription(categoryDetails.getDescription());
        category.setColor(categoryDetails.getColor());
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    public void deleteAllCategory() {
        categoryRepo.deleteAll();
        System.out.println("All transactions deleted successfully");
    }
}
