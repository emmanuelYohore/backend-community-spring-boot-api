package com.emmanuel.community_api.services;

import java.util.List;

import com.emmanuel.community_api.dtos.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(String id);
    List<CommentDto> getAllComment();
    CommentDto updateComment(String id, CommentDto commentDto);
    void deleteComment(String id);
}
