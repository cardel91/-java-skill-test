package com.example.restfulwebservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.repository.PostRepo;

@RestController
public class PostCtrl {
	
	private final PostRepo postRepo;

	public PostCtrl(PostRepo postRepo) {
		this.postRepo = postRepo;
	}
	
	@GetMapping("/posts")
	List<Post> findAll() {
		return postRepo.findAll();
	}
	
	@GetMapping("/posts/{id}")
	Post findById(@PathVariable String id) {
		return postRepo.findById(id).orElseThrow(()-> new PostNotFoundException(id));
	}
	
	@PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    Post save(@RequestBody @Valid Post post)
    {
        return postRepo.save(post);
    }
	
	@PutMapping("/posts/{id}")
	Post edit(@RequestBody Post newPost, @PathVariable String id) {
		return postRepo.findById(id).map(post -> {
			post.setUser(newPost.getUser());
			post.setTitle(newPost.getTitle());
			post.setUpdated(LocalDateTime.now());
			return postRepo.save(post);
		}).orElseGet(()-> {
			newPost.setId(id);
			return save(newPost);
		});
	}
	
	@DeleteMapping("/posts/{id}")
	void delete(@PathVariable String id) {
		postRepo.deleteById(id);
	}
	

}
