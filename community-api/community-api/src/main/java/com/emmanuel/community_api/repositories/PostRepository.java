package com.emmanuel.community_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emmanuel.community_api.entities.Post;

public interface PostRepository extends JpaRepository<Post, String> {

}
