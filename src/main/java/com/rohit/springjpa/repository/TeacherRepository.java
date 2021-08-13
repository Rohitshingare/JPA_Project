package com.rohit.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.springjpa.model.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
