package com.rohit.springjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springjpa.model.Student;
import com.rohit.springjpa.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentRepositoryTest {
    @Autowired
	private StudentRepository studentrepository;
    
    @PostMapping("/post")
    Student saveStudent(@RequestBody Student student) {
    	
		return studentrepository.save(student);
    	
    }
    @GetMapping("/all")
    List<Student> getStudents()
    {
		return studentrepository.findAll();
    	
    }
    @GetMapping("/printStudentbyfirstname")
    List<Student> printStudentByFirstName(){
		return  studentrepository.findByFirstName("vishya");
		
		}
    @GetMapping("/printStudentByFirstNameContaining/{firstchar}")
    List<Student> printStudentByFirstNameContaining(@PathVariable String firstchar){
		return studentrepository.findByFirstNameContaining(firstchar);
		
	}
    @GetMapping("/printStudentBasedOnGuardianName")
    List<Student> printStudentBasedOnGuardianName(){
		return studentrepository.findByGuardianName("Nikhil");
    	
    }
    @GetMapping("/printgetStudentByEmailAddress")
   Student printgetStudentByEmailAddress() {
    	
    	Student student = studentrepository.getStudentByEmailAddress("rohit@gmail.com");
	return student;
    	
    	
    }
    @GetMapping("/printgetStudentFirstNameByEmailAddress")
   String printgetStudentFirstNameByEmailAddress() {
    	String firstName =
    			studentrepository.getStudentFirstNameByEmailAddress(
                        "rohit@gmail.com"
                );
	return firstName;
	   
   }
    @GetMapping("/printgetStudentByEmailAddressNative")
    Student printgetStudentByEmailAddressNative(){
    	Student student =
    			studentrepository.getStudentByEmailAddressNative(
                        "rohit@gmail.com"
                );
		return student;

    }
    @GetMapping("/printgetStudentByEmailAddressNativeNamedParam")
    Student  printgetStudentByEmailAddressNativeNamedParam(){
    	Student student =
    			studentrepository.getStudentByEmailAddressNativeNamedParam(
                        "rohit@gmail.com");
		return student;
    }
    @GetMapping("/updateStudentNameByEmailIdTest/{firstName}/email/{emailId}")
    int  updateStudentNameByEmailIdTest(@PathVariable String firstName, @PathVariable String emailId) {
		return studentrepository.updateStudentNameByEmailId(
				firstName,
				emailId);
    	
    }
}
