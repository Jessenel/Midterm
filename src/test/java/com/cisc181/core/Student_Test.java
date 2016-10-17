package com.cisc181.core;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;


public class Student_Test {
	static Course course1 = new Course();
	static Course course2 = new Course();
	static Course course3 = new Course();
	static Semester fall = new Semester();
	static Semester spring = new Semester();
	static Section section1 =new Section();
	static Section section2 =new Section();
	static Section section3 =new Section();
	static Section section4 =new Section();
	static Section section5 =new Section();
	static Section section6 =new Section();
	
	static ArrayList<Course> course = new ArrayList<Course>();
	static ArrayList<Semester> semester = new ArrayList<Semester>();
	static ArrayList<Section> section = new ArrayList<Section>();
	static ArrayList<Student> student = new ArrayList<Student>();

	@BeforeClass
	public static void setup() throws PersonException {
		
		

		
		// three Course records
		course1.setCourseName("Chem101");
		course1.setCourseID(java.util.UUID.randomUUID() );
		course1.setGradePoints(4);
		course1.setMajor(eMajor.CHEM);

		course2.setCourseName("Chem201");
		course2.setCourseID(java.util.UUID.randomUUID());
		course2.setGradePoints(4);
		course2.setMajor(eMajor.CHEM);

		course3.setCourseName("Chem301");
		course3.setCourseID(java.util.UUID.randomUUID());
		course3.setGradePoints(4);
		course3.setMajor(eMajor.CHEM);

		course.add(course1);
		course.add(course2);
		course.add(course3);
		
		fall.setSemesterID(java.util.UUID.randomUUID());
		fall.setStartDate(new Date(2016,8,29));
		fall.setEndDate(new Date(2016,12,26));


		spring.setSemesterID(java.util.UUID.randomUUID());
		spring.setStartDate(new Date(2017,2,7));
		spring.setEndDate(new Date(2017,5,26));

		semester.add(fall);
		semester.add(spring);

		section1.setCourseID(course1.getCourseID());
		section1.setSemesterID(fall.getSemesterID());
		section1.setRoomID(java.util.UUID.randomUUID());
		section1.setRoomID(java.util.UUID.randomUUID());

		section2.setCourseID(course1.getCourseID());
		section2.setSemesterID(spring.getSemesterID());
		section2.setRoomID(java.util.UUID.randomUUID());
		section2.setRoomID(java.util.UUID.randomUUID());

		section3.setCourseID(course2.getCourseID());
		section3.setSemesterID(fall.getSemesterID());
		section3.setRoomID(java.util.UUID.randomUUID());
		section3.setRoomID(java.util.UUID.randomUUID());

		section4.setCourseID(course2.getCourseID());
		section4.setSemesterID(spring.getSemesterID());
		section4.setRoomID(java.util.UUID.randomUUID());
		section4.setRoomID(java.util.UUID.randomUUID());

		section5.setCourseID(course3.getCourseID());
		section5.setSemesterID(fall.getSemesterID());
		section5.setRoomID(java.util.UUID.randomUUID());
		section5.setRoomID(java.util.UUID.randomUUID());

		section6.setCourseID(course3.getCourseID());
		section6.setSemesterID(spring.getSemesterID());
		section6.setRoomID(java.util.UUID.randomUUID());
		section6.setRoomID(java.util.UUID.randomUUID());

		section.add(section1);
		section.add(section2);
		section.add(section3);
		section.add(section4);
		section.add(section5);
		section.add(section6);
		
		Student one = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student two = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student three = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student four = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student five = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student six = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student seven = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student eight = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student nine = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		Student ten = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		
		student.add(one);
		student.add(two);
		student.add(three);
		student.add(four);
		student.add(five);
		student.add(six);
		student.add(seven);
		student.add(eight);
		student.add(nine);
		student.add(ten);
		
		
	}

	@Test
	public void Student_Grades() throws PersonException {
		
		ArrayList<Enrollment> enroll = new ArrayList<Enrollment>();
		for (Student f : student) {
			for (Section g : section) {
				Enrollment fgenroll = new Enrollment(f.getStudentID(), g.getSectionID());
				enroll.add(fgenroll);
			}
		}
		
		for (Enrollment i : enroll) {
			i.setGrade(3.0);
		}

		for (Student stud : student) {
			int count = 0;
			double GPA = 0;
			for (Enrollment a : enroll) {
				if (count >= 12)
					break;
				else if (a.getStudentID().equals(stud.getStudentID())) {
					count++;
					GPA += a.getGrade();
				}
			}
			GPA = GPA / 12.0;
			assertEquals(3.0, GPA, 0);
		}
		for (Course b : course) {
			int count = 0;
			double GPA = 0;
			for (Section c : section) {
				if (b.getCourseID().equals(c.getCourseID())) {
					for (Enrollment a : enroll) {
						if (count >= 40)
							break;
						else if (a.getSectionID().equals(c.getSectionID())) {
							count++;
							GPA += a.getGrade();
						}
					}
				}
			}
			
			GPA = GPA / 40.0;
			assertEquals(3.0, GPA, 0);
		}
		
		

	}
	
	@Test 
	public void Student_major() throws PersonException{
		
		
		Student three = new Student("Jesse", "William", "Nelson", new Date(), eMajor.CHEM, "19 Pierce Rd.", "9734772093", "jessenel@udel.edu");
		
		
		three.seteMajor(eMajor.COMPSI);
		assertTrue(three.geteMajor() == eMajor.COMPSI);
	}
}