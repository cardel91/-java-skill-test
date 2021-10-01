package com.example.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulwebservices.model.User;

public interface UserRepo extends JpaRepository<User, String>{

}
