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
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.repository.PostRepo;
import com.example.restfulwebservices.repository.UserRepo;

@RestController
public class PostCtrl {
	
	private final PostRepo postRepo;
	private final UserRepo userRepo; 

	public PostCtrl(PostRepo postRepo, UserRepo userRepo) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
	}
	
	@GetMapping("/users/{userId}/posts")
	List<Post> findAll(@PathVariable String userId) {
		return postRepo.getByUserId(userId);
	}
	
	@GetMapping("/users/{userId}/posts/{id}")
	Post findById(@PathVariable String userId, @PathVariable String id) {
		return postRepo.getPost(userId, id).orElseThrow(()-> new PostNotFoundException(id));
	}
	
	@PostMapping("/users/{userId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    Post save(@PathVariable String userId, @RequestBody @Valid Post post)
    {
		User u = userRepo.getById(userId);
		post.setUser(u);
        return postRepo.save(post);
    }
	
	@PutMapping("/users/{userId}/posts/{id}")
	Post edit(@RequestBody Post newPost, @PathVariable String userId, @PathVariable String id) {
		return postRepo.findById(id).map(post -> {
//			post.setUser(newPost.getUser());
			post.setTitle(newPost.getTitle());
			post.setUpdated(LocalDateTime.now());
			return postRepo.save(post);
		}).orElseGet(()-> {
			newPost.setId(id);
			return save(userId, newPost);
		});
	}
	
	@DeleteMapping("/users/{userId}/posts/{id}")
	void delete(@PathVariable String userId, String id) {
		postRepo.deleteByUserId(userId, id);
	}
	

}
