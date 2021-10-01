package com.example.restfulwebservices;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.repository.PostRepo;
import com.example.restfulwebservices.repository.UserRepo;

@Configuration
public class DataLoader {
	
	private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
	
	@Bean
	CommandLineRunner initDatabase(UserRepo userRepo, PostRepo postRepo) {
		return args -> {
			User u = new User("jdoe","John","Doe", LocalDate.parse("1986-03-12"));
			userRepo.save(u);
			userRepo.findAll().forEach(user-> log.info("Preloaded "+user));
			
			postRepo.save(new Post(u, "My first post"));
			postRepo.findAll().forEach(post-> log.info("Preloaded "+post));
			
		};
	}

}
