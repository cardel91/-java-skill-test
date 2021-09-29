package com.example.restfulwebservices.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.restfulwebservices.model.Post;

public interface PostRepo extends CrudRepository<Post, Long>{

	@Transactional
	@Modifying
	@Query("delete from Post f where f.userId=:id")
	void deleteByUserId(@Param("id") Long id);
	
	@Query("select e from Post e where e.userId=:id")
	List<Post> getByUserId(@Param("id") Long id);
}
