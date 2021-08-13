package com.rohit.springjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor //not working
//@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
 //   @GeneratedValue(strategy = GenerationType.IDENTITY) for my checking
    Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;
  @Embedded
  private Guardian guardian;
  
  

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public Student(Long studentId, String firstName, String lastName, String emailId) {
	super();
	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
}


	public Long getStudentId() {
		return studentId;
	}

	

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public Student setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Student setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmailId() {
		return emailId;
	}

	public Student setEmailId(String emailId) {
		this.emailId = emailId;
		return this;
	}
	  public Guardian getGuardian() {
			return guardian;
		}


		public Student setGuardian(Guardian guardian) {
			this.guardian = guardian;
			return this;
		}


}

