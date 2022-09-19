package com.hu.eric.gpa;

import java.util.ArrayList;

/**
 * This is our main control class, which can be used to calculate a student's GPA.
 * To calculate a specific student's GPA, input their grades into the createStudent method.
 * 
 * @author Eric Hu
 *
 */
public class GPACalculator {

	/**
	 * This is the main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Student student = createStudent();
		double studentGPA = student.getWeightedGPA();
		System.out.print(student.getName() + "'s weighted GPA is: " + studentGPA);
		
	}

	/**
	 * This method creates a student with their grade history.
	 * 
	 * @return the student object
	 */
	public static Student createStudent() {
		//Creates student object
		Student john = new Student("John");
		
		//Creates ArrayList to hold freshman year courses
		ArrayList<Course> freshmanCourses = new ArrayList<Course>();
		//Adds all freshman year courses and course grades(by quarter)
		freshmanCourses.add(new Course("Ceramics", 				Level.UNLEVELED, 	5.0,	new double[]{90.0, 90.0, 87.0, 90.0}));
		freshmanCourses.add(new Course("Earth & Env.Sci", 		Level.AE, 			5.0,	new double[]{87.6, 89.5, 90.2, 93.8}));
		freshmanCourses.add(new Course("English I", 			Level.H_AP,			5.0, 	new double[]{89.4, 88.5, 90.1, 90.6}));
		freshmanCourses.add(new Course("Phys. Ed.",			 	Level.UNLEVELED, 	2.5,	new double[]{98.0, 98.0, 98.0, 98.0}));
		freshmanCourses.add(new Course("Algebra I", 			Level.AE, 			5.0,	new double[]{94.5, 87.5, 92.7, 93.2}));
		freshmanCourses.add(new Course("Spanish I", 			Level.AE,	 		5.0,	new double[]{88.3, 88.0, 89.5, 90.1}));
		freshmanCourses.add(new Course("World History", 		Level.H_AP, 		5.0,	new double[]{88.6, 87.8, 89.1, 89.3}));
		
		//Creates freshman school year
		SchoolYear freshman = new SchoolYear(YearName.FRESHMAN, freshmanCourses);
		
		//Adds freshman school year to student object
		john.addSchoolYear(freshman);
		
		
		ArrayList<Course> sophomoreCourses = new ArrayList<Course>();
		sophomoreCourses.add(new Course("Economics", 			Level.AE, 			5.0,	new double[]{90.0, 93.5, 92.4, 91.6}));
		sophomoreCourses.add(new Course("Geometry", 			Level.H_AP, 		5.0,	new double[]{89.4, 90.5, 90.1, 92.0}));
		sophomoreCourses.add(new Course("Biology", 				Level.H_AP,			5.0,	new double[]{87.8, 89.9, 83.2, 90.5}));
		sophomoreCourses.add(new Course("English II", 			Level.AE, 			5.0,	new double[]{91.4, 87.5, 89.9, 92.5}));
		sophomoreCourses.add(new Course("Grphic Design I", 		Level.UNLEVELED, 	1.25,	new double[]{95.0, 95.0, -1, -1}));
		sophomoreCourses.add(new Course("Phys. Ed.", 			Level.UNLEVELED,	1.25,	new double[]{-1, -1, 98.0, 98.0}));
		sophomoreCourses.add(new Course("Spanish II", 			Level.AE, 			5.0,	new double[]{94.3, 92.1, 90.1, 92.3}));
		sophomoreCourses.add(new Course("U.S. Hist/Gv I", 		Level.H_AP, 		5.0,	new double[]{86.7, 88.9, 90.9, 88.7}));
		SchoolYear sophomore = new SchoolYear(YearName.SOPHOMORE, sophomoreCourses);
		
		john.addSchoolYear(sophomore);
		
		
		ArrayList<Course> juniorCourses = new ArrayList<Course>();
		juniorCourses.add(new Course("Chemistry", 				Level.H_AP, 		5.0,	new double[]{94.1, 93.6, 93.1, 90.5}));
		juniorCourses.add(new Course("Phys. Ed.", 				Level.UNLEVELED, 	1.25,	new double[]{98.0, 98.0, -1, -1}));
		juniorCourses.add(new Course("Grphic Design II", 		Level.UNLEVELED,	1.25,	new double[]{-1 -1, 94.0, 90.0}));
		juniorCourses.add(new Course("English III", 			Level.AE, 			5.0,	new double[]{92.6, 91.9, 95.0, 94.2}));
		juniorCourses.add(new Course("Precalc", 				Level.AE, 			5.0,	new double[]{88.9, 89.5, 90.2, 90.9}));
		juniorCourses.add(new Course("Macroeconomics", 			Level.H_AP,			5.0,	new double[]{93.2, 91.7, 87.4, 92.1}));
		juniorCourses.add(new Course("Spanish III", 			Level.AE, 			5.0,	new double[]{92.1, 94.2, 94.2, 93.5}));
		juniorCourses.add(new Course("U.S. Hist/Gv II", 		Level.H_AP, 		5.0,	new double[]{94.3, 91.4, 93.5, 92.7}));
		SchoolYear junior = new SchoolYear(YearName.JUNIOR, juniorCourses);
		
		john.addSchoolYear(junior);
		
		
		ArrayList<Course> seniorCourses = new ArrayList<Course>();
		seniorCourses.add(new Course("Calculus", 				Level.H_AP, 		5.0,	new double[]{91.2, 90.4, 87.5, 89.9}));
		seniorCourses.add(new Course("Physics", 				Level.H_AP,	 		5.0,	new double[]{88.0, 89.3, 88.7, 90.2}));
		seniorCourses.add(new Course("Physics Lab", 			Level.H_AP,			2.5,	new double[]{88.0, 89.3, 88.7, 90.2}));
		seniorCourses.add(new Course("Java",				 	Level.UNLEVELED, 	2.5,	new double[]{98.2, 97.7, 97.5, 98.3}));
		seniorCourses.add(new Course("English IV",				Level.UNLEVELED, 	5.0,	new double[]{91.4, 93.5, 93.2, 92.6}));
		seniorCourses.add(new Course("Accounting", 				Level.H_AP,			5.0,	new double[]{95.6, 93.4, 92.5, 96.0}));
		seniorCourses.add(new Course("Spanish IV", 				Level.H_AP,			5.0,	new double[]{88.4, 89.8, 88.2, 88.7}));
		seniorCourses.add(new Course("Europ.History", 			Level.H_AP,			5.0,	new double[]{87.5, 86.8, 87.6, 89.3}));
		SchoolYear senior = new SchoolYear(YearName.SENIOR, seniorCourses);
		
		john.addSchoolYear(senior);
		
		return john;
	}
	
}
