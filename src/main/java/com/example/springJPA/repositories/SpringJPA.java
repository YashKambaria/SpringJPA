package com.example.springJPA.repositories;

import com.example.springJPA.schema.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringJPA extends JpaRepository<Course,Long> {
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
