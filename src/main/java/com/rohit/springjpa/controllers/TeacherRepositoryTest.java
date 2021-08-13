package com.rohit.springjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springjpa.model.Course;
import com.rohit.springjpa.model.Teacher;
import com.rohit.springjpa.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherRepositoryTest {
	@Autowired
	private TeacherRepository teacherrepository;
	
	
	 @GetMapping("/getteachers")
	 public List<Teacher> saveTeacher() {
		 

	 Course courseDBA = new Course();
	 
	 courseDBA.setTitle("DBA")
	                .setCredit(5);
	                

	        Course courseJava = new Course();
	            
	        courseJava.setTitle("Java")
	                .setCredit(6);
	             
	        Teacher teacher =  new Teacher();
	        
	        teacher.setFirstName("Rohit")
	               .setLastName("Shingare");
	        
	        teacher.setCourses(List.of(courseDBA,courseJava));
	                       

	        teacherrepository.save(teacher);
		 
		 
		 
		return teacherrepository.findAll();
		 
		 
	 }


	

}
