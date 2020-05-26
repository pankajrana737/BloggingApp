package com.example.arv.bloggingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arv.bloggingapp.domains.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, String>{

}
