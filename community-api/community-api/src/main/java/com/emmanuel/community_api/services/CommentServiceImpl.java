package com.emmanuel.community_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emmanuel.community_api.dtos.CommentDto;
import com.emmanuel.community_api.entities.Comment;
import com.emmanuel.community_api.mappers.CommentMapperImpl;
import com.emmanuel.community_api.repositories.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CommentMapperImpl commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapperImpl commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = commentMapper.fromCommentDto(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.fromComment(savedComment);
    }

    public CommentDto getCommentById(String id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return commentMapper.fromComment(comment);
    }

    public List<CommentDto> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(comment -> commentMapper.fromComment(comment)).collect(Collectors.toList());
    }

    public CommentDto updateComment(String id, CommentDto commentDto) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        existingComment.setContent(commentDto.getContent());

        Comment updatedComment = commentRepository.save(existingComment);
        return commentMapper.fromComment(updatedComment);
    }

    public void deleteComment(String id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
}
