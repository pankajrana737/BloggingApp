package com.example.arv.bloggingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.arv.bloggingapp.api.v1.models.CommentDTO;
import com.example.arv.bloggingapp.domains.BlogPost;
import com.example.arv.bloggingapp.domains.Comment;
import com.example.arv.bloggingapp.repositories.BlogPostRepository;
import com.example.arv.bloggingapp.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepo;
	private final BlogPostRepository blogPostRepo;

	public CommentServiceImpl(CommentRepository commentRepo, BlogPostRepository blogPostRepo) {
		this.commentRepo = commentRepo;
		this.blogPostRepo = blogPostRepo;
	}

	@Override
	public List<CommentDTO> getCommentsByPostId(String id) {
		return commentRepo.findByBlogPostId(id).stream().map(comment -> commentToCommentDto(comment))
				.collect(Collectors.toList());
	}

	@Override
	public CommentDTO postCommentToBlogPost(String id, CommentDTO commentDto) {
		BlogPost blog = blogPostRepo.findById(id).orElseThrow(ResourceNotFoundException::new);

		Comment comment = commentDtoToComment(commentDto);
		comment.getBlogPost().setId(id);
		Comment savedComment = commentRepo.save(comment);
		CommentDTO resultComment = commentToCommentDto(savedComment);

		blog.getComments().add(savedComment);
		blogPostRepo.save(blog);

		return resultComment;
	}

	@Override
	public CommentDTO getCommentById(String id) {
		return commentRepo.findById(id).map(comment -> commentToCommentDto(comment))
				.orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public CommentDTO updateComment(String id, CommentDTO commentDto) {
		Comment comment = commentDtoToComment(commentDto);
		comment.setBlogPost(commentRepo.findById(id).orElseThrow(ResourceNotFoundException::new).getBlogPost());
		comment.setId(id);
		return commentToCommentDto(commentRepo.save(comment));
	}

	@Override
	public void deleteComment(String id) {
		commentRepo.deleteById(id);
	}

	// TODO: move below methos to mapper
	private CommentDTO commentToCommentDto(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.set_id(comment.getId());
		commentDTO.setContent(comment.getContent());
		return commentDTO;
	}

	private Comment commentDtoToComment(CommentDTO commentDto) {
		Comment comment = new Comment();
		comment.setContent(commentDto.getContent());
		return comment;
	}

}
