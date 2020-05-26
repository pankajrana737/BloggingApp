package com.example.arv.bloggingapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.arv.bloggingapp.api.v1.models.BlogPostDTO;
import com.example.arv.bloggingapp.service.BlogPostService;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
	
	private final BlogPostService blogPostService;
	
	public BlogPostController(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

	@GetMapping
	public List<BlogPostDTO> getBlogPosts(){
		return blogPostService.getAllBlogPost();
	}
	
	@GetMapping("/{id}")
	public BlogPostDTO getBlogPostById(@PathVariable String id){
		return blogPostService.getBlogPostById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BlogPostDTO createNewBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
		return blogPostService.createNewBlogPost(blogPostDTO);
	}
	
	@PutMapping("/{id}")
	public BlogPostDTO updateBlogPost(@PathVariable String id, @RequestBody BlogPostDTO blogPostDTO) {
		return blogPostService.updateBlogPost(id, blogPostDTO);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBlogPost(@PathVariable String id) {
		blogPostService.deleteBlogPost(id);
	}
	
}
