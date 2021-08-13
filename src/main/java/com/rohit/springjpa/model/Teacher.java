package com.rohit.springjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
    
    
    

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Teacher(Long teacherId, String firstName, String lastName, List<Course> courses) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}


	public Long getTeacherId() {
		return teacherId;
	}

	public Teacher setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Teacher setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
    
}
