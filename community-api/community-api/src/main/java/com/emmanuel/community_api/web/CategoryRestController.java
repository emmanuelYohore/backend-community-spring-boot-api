package com.emmanuel.community_api.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.community_api.dtos.CategoryDto;
import com.emmanuel.community_api.services.CategoryService;

@RestController
public class CategoryRestController {

    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/api/v1/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping(path = "/api/v1/categories/{categoryId}")
    public CategoryDto getCategoryById(@PathVariable String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/api/v1/categories")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/api/v1/categories/{categoryId}")
    public CategoryDto updateCategory(@PathVariable String categoryId, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto);
    }

    @DeleteMapping("/api/v1/categories/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
