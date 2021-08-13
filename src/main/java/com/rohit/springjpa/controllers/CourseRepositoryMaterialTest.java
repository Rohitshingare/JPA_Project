package com.rohit.springjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Couchbase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springjpa.model.Course;
import com.rohit.springjpa.model.CourseMaterial;
import com.rohit.springjpa.repository.CourseMaterialRepository;
import com.rohit.springjpa.repository.CourseRepository;

@RestController
@RequestMapping("/coursematerials")
public class CourseRepositoryMaterialTest {
	@Autowired
	CourseMaterialRepository courseMaterialRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/postcourseMaterials")
	CourseMaterial saveCourseDetails(@RequestBody CourseMaterial courseMaterial){
		
		return courseMaterialRepository.save(courseMaterial);
		
	}

	@GetMapping("/getcourseMaterials")
	List<CourseMaterial> getCouses(){
		return courseMaterialRepository.findAll();
		
	}
	@PutMapping("/{courseID}/CourseMaterials/{courseMaterialsId}")
	Course addMaterialTocourse(@PathVariable Long courseID, @PathVariable Long courseMaterialsId){
		
		Course course = courseRepository.findById(courseID).get();
		CourseMaterial courseMaterial = courseMaterialRepository.findById(courseMaterialsId).get();
		course.setCourseMaterial(courseMaterial);
		
		return courseRepository.save(course);
		
	}

}
