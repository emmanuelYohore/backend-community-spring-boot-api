package com.emmanuel.community_api.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.community_api.dtos.CommentDto;
import com.emmanuel.community_api.services.CommentService;

@RestController
public class CommentRestController {

    private CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/api/v1/comments")
    public List<CommentDto> getAllComments() {
        return commentService.getAllComment();
    }

    @GetMapping(path = "/api/v1/comments/{commentId}")
    public CommentDto getCommentById(@PathVariable String commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/api/v1/comments")
    public CommentDto saveComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PutMapping("/api/v1/comments/{commentId}")
    public CommentDto updateComment(@PathVariable String commentId, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/api/v1/comments/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        commentService.deleteComment(commentId);
    }
}
