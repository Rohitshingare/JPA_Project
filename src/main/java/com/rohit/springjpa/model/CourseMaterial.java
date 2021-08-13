package com.rohit.springjpa.model;


import javax.persistence.*;



@Entity

//@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;
    
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
   private Course course;
    

	public CourseMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CourseMaterial(Long courseMaterialId, String url, Course course) {
		super();
		this.courseMaterialId = courseMaterialId;
		this.url = url;
		this.course = course;
	}


	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    
}
