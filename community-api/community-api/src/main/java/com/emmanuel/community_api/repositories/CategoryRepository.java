package com.emmanuel.community_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emmanuel.community_api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String>  {
    
}

