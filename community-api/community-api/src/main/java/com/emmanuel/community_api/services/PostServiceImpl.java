package com.emmanuel.community_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emmanuel.community_api.dtos.PostDto;
import com.emmanuel.community_api.entities.Post;
import com.emmanuel.community_api.mappers.PostMapperImpl;
import com.emmanuel.community_api.repositories.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapperImpl postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapperImpl postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.fromPostDto(postDto);
        Post savedPost = postRepository.save(post);
        return postMapper.fromPost(savedPost);
    }

    public PostDto getPostById(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return postMapper.fromPost(post);
    }

    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> postMapper.fromPost(post)).collect(Collectors.toList());
    }

    public PostDto updatePost(String id, PostDto postDto) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setTitle(postDto.getTitle());
        existingPost.setDescription(postDto.getDescription());

        Post updatedPost = postRepository.save(existingPost);
        return postMapper.fromPost(updatedPost);
    }

    public void deletePost(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}
