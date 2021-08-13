package com.rohit.springjpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.springjpa.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
   
}
