package com.rohit.springjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
    @JsonIgnore
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

	

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "studen_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;


  

	public List<Student> addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
		return students;
    }
    
    //getter-setter
    public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    public Course(Long courseId, String title, Integer credit, CourseMaterial courseMaterial) {
	super();
	this.courseId = courseId;
	this.title = title;
	this.credit = credit;
	this.courseMaterial = courseMaterial;
}


	public Long getCourseId() {
		return courseId;
	}

	
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public Course setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getCredit() {
		return credit;
	}

	public Course setCredit(Integer credit) {
		this.credit = credit;
		return this;
	}

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public Teacher getTeacher() {
		return teacher;
	}


	public Course setTeacher(Teacher teacher) {
		this.teacher = teacher;
		return this;
	}


	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}
	  public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}
}
