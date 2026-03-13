package com.emmanuel.community_api.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.emmanuel.community_api.dtos.CategoryDto;
import com.emmanuel.community_api.entities.Category;

@Service
public class CategoryMapperImpl {

    public CategoryDto fromCategory(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    public Category fromCategoryDto(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }
}
