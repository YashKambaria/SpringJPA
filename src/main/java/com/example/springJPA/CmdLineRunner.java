package com.example.springJPA;

import com.example.springJPA.repositories.CourseJDBCRepositary;
import com.example.springJPA.repositories.CourseJPARepositary;
import com.example.springJPA.repositories.SpringJPA;
import com.example.springJPA.schema.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJDBCRepositary courseJDBCRepositary;
	
	@Autowired
	private CourseJPARepositary courseJPARepositary;
	
	@Autowired
	private SpringJPA springJPA;
	
	@Override
	public void run(String... args) throws Exception {
		springJPA.save(new Course(1,"hello","world"));
		springJPA.save(new Course(2,"hell","world"));
		springJPA.save(new Course(3,"hel","world"));
		
		springJPA.deleteById(2l);
		System.out.println(springJPA.findById(1l));
		System.out.println(springJPA.findById(3l));
		System.out.println(springJPA.findByAuthor("world"));
		System.out.println(springJPA.findByName("hel"));
		
	}
}
