package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment(){
		this.EnrollmentID = UUID.randomUUID();
		
	}
	
	public Enrollment(UUID SectionID, UUID StudentID){
		this();
		this.SectionID = SectionID;
		this.StudentID = StudentID;
		
	}


	public void setGrade(double grade) {
		Grade = grade;
	}
	
	public double getGrade() {
		return this.Grade;
	}
	
	public UUID getStudentID() {
		return this.StudentID;
	}
	
	public UUID getSectionID() {
		return this.SectionID;
	}

	

}
