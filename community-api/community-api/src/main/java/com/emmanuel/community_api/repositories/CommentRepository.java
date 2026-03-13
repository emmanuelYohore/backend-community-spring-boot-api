package com.emmanuel.community_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emmanuel.community_api.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, String>  {
    
}
