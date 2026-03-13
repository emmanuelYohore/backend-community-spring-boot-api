package com.emmanuel.community_api.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.emmanuel.community_api.dtos.CommentDto;
import com.emmanuel.community_api.entities.Comment;

@Service
public class CommentMapperImpl {

    public CommentDto fromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment, commentDto);
        return commentDto;
    }

    public Comment fromCommentDto(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        return comment;
    }
}
