package com.example.restfulwebservices.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class UserCtrl {
	
	private final UserRepo userRepo;
	private final PostRepo postRepo;
	
	public UserCtrl(UserRepo userRepo, PostRepo postRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
	}
	
	
	@GetMapping("/users")
	List<User> findAll() {
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	User findById(@PathVariable String id) {
		return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    User save(@RequestBody @Valid User user)
    {
        return userRepo.save(user);
    }
	
	@PutMapping("/users/{id}")
	User edit(@RequestBody User newUser, @PathVariable String id) {
		return userRepo.findById(id).map(user -> {
			user.setBirthDate(newUser.getBirthDate());
			user.setUsername(newUser.getUsername());
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setUpdated(LocalDateTime.now());
			return userRepo.save(user);
		}).orElseGet(()-> {
			newUser.setId(id);
			return save(newUser);
		});
	}
	
	@DeleteMapping("/users/{id}")
	void delete(@PathVariable String id) throws UserNotFoundException {
		try {
//			List<Post> posts = postRepo.getByUserId(id);
//			if (posts.size() > 0) {
//				
//				postRepo.deleteAll(posts);
//			}
			userRepo.deleteById(id);
		} catch (Exception e) {
			throw new UserNotFoundException(id);
		}
		
	}
	
}
