package com.hu.eric.gpa;

import java.util.ArrayList;

public class SchoolYear {
	
	private YearName yearName;
	private ArrayList<Course> courses;
	
	public double getGPA() {
		int numCourses = 0;
		double totalGPA = 0.0;
		
		for (Course item: this.courses) {
			
			if (item.getLevel() == Level.UNLEVELED) {
				continue;
			}
			
			double courseGPA = 0;
			LetterGrade letterGrade = item.getLetterGrade();

			switch (item.getLevel()) {
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
			
			numCourses++;
			totalGPA += courseGPA;
			System.out.println(item.getName() + "\t\t" + item.getCourseAvg() + "\t\t" + item.getLetterGrade());
		}
		System.out.println("School Year: " + this.getYearName() + "\tGPA: " + totalGPA/numCourses);
		
		return 0.0;
	}
	
	public SchoolYear(YearName yearName, ArrayList<Course> courses) {
		this.yearName = yearName;
		this.courses = courses;
	}

	public YearName getYearName() {
		return yearName;
	}

	public void setYearName(YearName yearName) {
		this.yearName = yearName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String yearSummary = "This is your " + yearName + " year.\n";
		for (Course item: this.courses) {
			yearSummary += item.toString();
			yearSummary += "\n";
		}
		return yearSummary;
	}

	
	
}
