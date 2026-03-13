package com.emmanuel.community_api.services;

import java.util.List;

import com.emmanuel.community_api.dtos.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    CategoryDto getCategoryById(String id);
    List<CategoryDto> getAllCategory();
    CategoryDto updateCategory(String id, CategoryDto category);
    void deleteCategory(String id);
}
