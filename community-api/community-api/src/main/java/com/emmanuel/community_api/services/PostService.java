package com.emmanuel.community_api.services;

import java.util.List;

import com.emmanuel.community_api.dtos.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(String id);
    List<PostDto> getAllPost();
    PostDto updatePost(String id, PostDto postDto);
    void deletePost(String id);
}
