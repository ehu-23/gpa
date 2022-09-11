package com.hu.eric.gpa;

import java.util.ArrayList;

/**
 * This class models a school year, which includes a year name and a list of courses.
 * 
 * @author Eric Hu
 *
 */
public class SchoolYear {
	
	private YearName yearName;
	private ArrayList<Course> courses;
	
	/**
	 * This is the constructor
	 * 
	 * @param yearName school year name
	 * @param courses school year courses
	 */
	public SchoolYear(YearName yearName, ArrayList<Course> courses) {
		this.yearName = yearName;
		this.courses = courses;
	}

	/**
	 * Gets school year name
	 * 
	 * @return school year name
	 */
	public YearName getYearName() {
		return yearName;
	}

	/**
	 * Sets school year name
	 * 
	 * @param yearName school year name
	 */
	public void setYearName(YearName yearName) {
		this.yearName = yearName;
	}

	/**
	 * Gets school year courses
	 * 
	 * @return school year courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * Sets school year courses
	 * 
	 * @param courses school year courses
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	/**
	 * This calculates weighted GPA using total GPA and total credits
	 * 
	 * @return weighted GPA
	 */
	public double getWeightedGPA() {
		double totalCredits = 0.0;
		double totalGPA = 0.0;
		
		for (Course course: this.courses) {
			
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
			//System.out.println(course.getName() + "\t\t" + course.getCourseAvg() + "\t\t" + course.getLetterGrade());
		}
		//System.out.println("School Year: " + this.getYearName() + "\tGPA: " + totalGPA/totalCredits);
		
		return totalGPA/totalCredits;
	}
	
	@Override
	public String toString() {
		String yearSummary = "This is your " + yearName + " year.\n";
		for (Course course: this.courses) {
			yearSummary += course.toString();
			yearSummary += "\n";
		}
		return yearSummary;
	}

	
	
}
