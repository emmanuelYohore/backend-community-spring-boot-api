package com.emmanuel.community_api.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.emmanuel.community_api.dtos.PostDto;
import com.emmanuel.community_api.entities.Post;

@Service
public class PostMapperImpl {

    public PostDto fromPost(Post post) {
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto);
        return postDto;
    }

    public Post fromPostDto(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        return post;
    }
}
