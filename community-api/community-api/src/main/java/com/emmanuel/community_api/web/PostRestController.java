package com.emmanuel.community_api.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.community_api.dtos.PostDto;
import com.emmanuel.community_api.services.PostService;

@RestController
public class PostRestController {

    private PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/api/v1/posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping(path = "/api/v1/posts/{postId}")
    public PostDto getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/api/v1/posts")
    public PostDto savePost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @PutMapping("/api/v1/posts/{postId}")
    public PostDto updatePost(@PathVariable String postId, @RequestBody PostDto postDto) {
        return postService.updatePost(postId, postDto);
    }

    @DeleteMapping("/api/v1/posts/{postId}")
    public void deletePost(@PathVariable String postId) {
        postService.deletePost(postId);
    }
}
