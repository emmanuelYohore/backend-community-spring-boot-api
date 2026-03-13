package com.emmanuel.community_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emmanuel.community_api.dtos.CategoryDto;
import com.emmanuel.community_api.entities.Category;
import com.emmanuel.community_api.mappers.CategoryMapperImpl;
import com.emmanuel.community_api.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapperImpl categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapperImpl categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.fromCategoryDto(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.fromCategory(savedCategory);
    }

    public CategoryDto getCategoryById(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.fromCategory(category);
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> categoryMapper.fromCategory(category)).collect(Collectors.toList());
    }

    public CategoryDto updateCategory(String id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(categoryDto.getName());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.fromCategory(updatedCategory);
    }

    public void deleteCategory(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
    }
}
