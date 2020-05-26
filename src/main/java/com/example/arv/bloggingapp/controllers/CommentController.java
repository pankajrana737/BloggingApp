package com.example.arv.bloggingapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.arv.bloggingapp.api.v1.models.CommentDTO;
import com.example.arv.bloggingapp.service.CommentService;

@RestController
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/posts/{id}/comments")
	public List<CommentDTO> getCommentsByPostId(@PathVariable String id) {
		return commentService.getCommentsByPostId(id);
	}

	@PostMapping("/posts/{id}/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public CommentDTO postCommentToBlogPost(@PathVariable String id, @RequestBody CommentDTO commentDto) {
		return commentService.postCommentToBlogPost(id, commentDto);
	}
	
	@GetMapping("/comments/{id}")
	public CommentDTO getCommentById(@PathVariable String id) {
		return commentService.getCommentById(id);
	}
	
	@PutMapping("/comments/{id}")
	public CommentDTO updateCommentById(@PathVariable String id, @RequestBody CommentDTO commentDto) {
		return commentService.updateComment(id, commentDto);
	}
	
	@DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCommentById(@PathVariable String id) {
		commentService.deleteComment(id);
	}
}
