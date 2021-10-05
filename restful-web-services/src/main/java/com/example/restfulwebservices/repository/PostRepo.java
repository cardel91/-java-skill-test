package com.example.restfulwebservices.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.restfulwebservices.model.Post;

public interface PostRepo extends JpaRepository<Post, String>{

	@Transactional
	@Modifying
	@Query("delete from Post f where f.user.id=:userId and f.id=:id" )
	void deleteByUserId(@Param("userId") String userId, @Param("id") String id);
	
	@Query("select e from Post e where e.user.id=:id")
	List<Post> getByUserId(@Param("id") String id);
	
	@Query("select e from Post e where e.id=:id and e.user.id=:userId")
	Optional<Post> getPost(@Param("userId") String userId, @Param("id") String id);
}
