package com.example.springJPA.repositories;

import com.example.springJPA.schema.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepositary {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY= """
			
			insert into course values(?,?,?);
			""";
	
	private static String DELETE_QUERY= """
			
			delete from course where id = ? ;
			""";
	
	
	private static String SELECT_QUERY= """
			select * from course where id=?;
			""";
	
	
	public void insert(Course course){
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	public void delete(long id){
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	public Course select(long id){
		return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
		
	}
}
