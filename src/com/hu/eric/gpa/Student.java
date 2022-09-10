package com.hu.eric.gpa;

import java.util.ArrayList;

import com.hu.eric.gpa.Course.LetterGrade;
import com.hu.eric.gpa.Course.Level;

public class Student {
	
	private String name;
	private SchoolYear[] grades;
	
	public Student(String name) {
		this.name = name;
		this.grades = new SchoolYear[4];
	}
	
	/**
	 * gets weighted gpa from student information
	 * 
	 * @return weighted gpa of student
	 */
	public double getWeightedGPA() {
		double totalGPA = 0.0;
		double totalCredits = 0.0;
		for (SchoolYear schoolYear: this.grades) {
			if (schoolYear==null) {
				continue;
			}
			for (Course course: schoolYear.getCourses()) {
				if (course.getLevel() == Level.UNLEVELED) {
					continue;
				}
				
				double courseGPA = 0;
				LetterGrade letterGrade = course.getLetterGrade();

				switch (course.getLevel()) {
				case H_AP:
					courseGPA = letterGrade.getHonorGPA();
					break;
				case AE:
					courseGPA = letterGrade.getAeGPA();
					break;
				case CP:
					courseGPA = letterGrade.getCpGPA();
					break;
				case CP1:
					courseGPA = letterGrade.getCp1GPA();
					break;
				default:
					System.out.println("Error");
				}
				totalCredits += course.getCredits();
				totalGPA += courseGPA*course.getCredits();
				System.out.println(course.getName() + "\t\t" + course.getCourseAvg() + "\t\t" + course.getLetterGrade());
			}
			
		}
		
		return totalGPA/totalCredits;
		
	}

	public void addSchoolYear(SchoolYear year) {
		int index = 0;
		switch (year.getYearName()) {
		case FRESHMAN:
			index = 0;
			break;
		case SOPHOMORE:
			index = 1;
			break;
		case JUNIOR:
			index = 2;
			break;
		case SENIOR:
			index = 3;
			break;
		}
		grades[index] = year;
		/*
		 * if (year.getYearName() == SchoolYear.YearName.FRESHMAN) { grades[0] = year; }
		 */		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolYear[] getGrades() {
		return grades;
	}

	public void setGrades(SchoolYear[] grades) {
		this.grades = grades;
	}

}
