package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistration 
{
	@Value("101")
	private int rollNo;
	@Value("Pavani")
	private String studentName;
	
	private String courseName;
	
	private int semester;
	
	public CourseRegistration(@Value("FSAD")String courseName)
	{
		this.courseName=courseName;
	}
	@Value("4")
	public void SetCourseRegistration(int semester)
	{
		this.semester=semester;
	}
	public void display()
	{
		System.out.println("RollNo : "+rollNo);
		System.out.println("Name : "+studentName);
		System.out.println("Course : "+courseName);
		System.out.println("Semester : "+semester);
	}
}
