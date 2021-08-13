package com.rohit.springjpa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springjpa.model.Teacher;

import com.rohit.springjpa.model.Course;
import com.rohit.springjpa.model.Student;
import com.rohit.springjpa.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/postcourse")
	Course saveCourseDetails(@RequestBody Course course){
		
		return courseRepository.save(course);
		
	}

	@GetMapping("/getcourse")
	List<Course> getCouses(){
		return courseRepository.findAll();
		
	}
	@GetMapping("/saveCourseWithTeacher")
	public List<Course> saveCourseWithTeacher() {
		
		Teacher teacher = new Teacher();
		 
		 teacher.setFirstName("Priyanka")
	                .setLastName("patil");
	                
	        Course course = new Course();
	               
	        course.setTitle("Python")
	                .setCredit(6)
	                .setTeacher(teacher);
	               

	        courseRepository.save(course);
			return courseRepository.findAll();
	}
	@GetMapping("/saveCourseWithStudentAndTeacher")
	public List<Course> saveCourseWithStudentAndTeacher() {
		Teacher teacher = new Teacher();
		 
		 teacher.setFirstName("Priyanka")
	                .setLastName("patil");

	        Student student = new Student();
	        
	        student.setFirstName("Abhishek")
	                .setLastName("deshpande")
	                .setEmailId("abhishek@gmail.com");
          Student student1 = new Student();
	        
	        student1.setFirstName("rohit")
	                .setLastName("shingare")
	                .setEmailId("rohit@gmail.com");
	                
	        Course course = new Course();
	                
	        course.setTitle("AI")
	                .setCredit(12)
	                .setTeacher(teacher);
	            
	        course.setStudents(List.of(student,student1));

	        courseRepository.save(course);
			return courseRepository.findAll();
	}
}
