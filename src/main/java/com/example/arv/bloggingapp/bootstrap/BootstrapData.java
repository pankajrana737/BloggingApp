package com.example.arv.bloggingapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.arv.bloggingapp.domains.BlogPost;
import com.example.arv.bloggingapp.domains.Comment;
import com.example.arv.bloggingapp.repositories.BlogPostRepository;
import com.example.arv.bloggingapp.repositories.CommentRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final BlogPostRepository blogPostRepo;
	private final CommentRepository commentRepo;

	public BootstrapData(BlogPostRepository blogPostRepo, CommentRepository commentRepo) {
		this.blogPostRepo = blogPostRepo;
		this.commentRepo = commentRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>Started in bootstrap");

		BlogPost inspiringBooks = new BlogPost();
		inspiringBooks.setTitle("Inspiring books for hard times");
		inspiringBooks.setSubtitle("Dummy Subtitle");
		inspiringBooks.setContent(
				"Cras mi quam, sagittis quis nulla eu, pharetra tempus felis. Nulla nibh purus, porttitor in magna et, tincidunt venenatis mi. In augue mauris, mollis ac sollicitudin id, lobortis id augue. Sed volutpat sagittis urna vitae rutrum. Integer mauris velit, semper sit amet ipsum posuere, sodales condimentum nunc. Proin cursus nunc at risus eleifend, vitae faucibus dui varius. Integer enim sapien, mollis non eleifend vitae, auctor et ante. Nunc mauris massa, pulvinar ut urna sit amet, tincidunt dapibus magna. In tempor mattis vehicula. Phasellus sit amet condimentum ipsum. Suspendisse vehicula a purus et tincidunt.");

		blogPostRepo.save(inspiringBooks);

		Comment nicePost = new Comment();
		nicePost.setBlogPost(inspiringBooks);
		nicePost.setContent("It is a nice post");

		commentRepo.save(nicePost);

		Comment awesomePost = new Comment();
		awesomePost.setBlogPost(inspiringBooks);
		awesomePost.setContent("Awesome post");
		commentRepo.save(awesomePost);

		inspiringBooks.getComments().add(nicePost);
		inspiringBooks.getComments().add(awesomePost);

		blogPostRepo.save(inspiringBooks);

		BlogPost citrusFruits = new BlogPost();
		citrusFruits.setTitle("Are you throwing out the best part of your citrus fruits?");
		citrusFruits.setSubtitle(
				"Behold the delicious treasures of the citrus peel; here's how to get the best of the zest.");
		citrusFruits.setContent(
				"Vivamus eget dapibus justo. Suspendisse diam est, dignissim sit amet tortor posuere, ullamcorper mollis orci. Fusce consectetur consequat eros, ac ullamcorper est pellentesque nec. Pellentesque a pulvinar mi. Vivamus risus nulla, gravida ac gravida quis, placerat in enim. Suspendisse quis dolor risus. In euismod diam ac lectus lobortis, ac egestas eros ultrices. Curabitur nec lectus at nibh ornare auctor. Nunc dapibus malesuada ullamcorper. Vestibulum quis malesuada risus. Phasellus venenatis convallis orci, eu facilisis lacus molestie sodales. Donec eget nibh sed orci convallis congue vitae id ante. Cras eros quam, vehicula quis congue sed, finibus ut metus. In volutpat ultrices velit ut vehicula.");
		blogPostRepo.save(citrusFruits);

		Comment thanks = new Comment();
		thanks.setBlogPost(citrusFruits);
		thanks.setContent("Thanks for sharing this.");

		commentRepo.save(thanks);
		citrusFruits.getComments().add(thanks);
		blogPostRepo.save(citrusFruits);

		System.out.println("Number of Blogs: " + blogPostRepo.count());

	}

}
