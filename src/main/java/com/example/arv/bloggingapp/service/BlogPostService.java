package com.example.arv.bloggingapp.service;

import java.util.List;

import com.example.arv.bloggingapp.api.v1.models.BlogPostDTO;

public interface BlogPostService {

	List<BlogPostDTO> getAllBlogPost();
	BlogPostDTO getBlogPostById(String id);
	BlogPostDTO createNewBlogPost(BlogPostDTO blogPostDTO);
	BlogPostDTO updateBlogPost(String id, BlogPostDTO blogPostDTO);
	void deleteBlogPost(String id);

}
