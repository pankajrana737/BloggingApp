package com.example.arv.bloggingapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arv.bloggingapp.domains.Comment;

public interface CommentRepository extends JpaRepository<Comment, String>{

	List<Comment> findByBlogPostId(String id);
	
}
