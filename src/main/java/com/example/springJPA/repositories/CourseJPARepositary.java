package com.example.springJPA.repositories;

import com.example.springJPA.schema.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepositary {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course){
		entityManager.merge(course);
	}
	public void delete(long id){
		var course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	public Course select(long id){
		return entityManager.find(Course.class,id);
	}
}
