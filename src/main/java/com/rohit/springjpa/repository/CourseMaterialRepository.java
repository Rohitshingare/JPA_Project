package com.rohit.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.springjpa.model.CourseMaterial;
@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
