package com.hu.eric.gpa;

import java.util.ArrayList;

import com.hu.eric.gpa.Course.LetterGrade;
import com.hu.eric.gpa.Course.Level;

public class SchoolYear {

	public static enum YearName {
		FRESHMAN,
		SOPHOMORE,
		JUNIOR,
		SENIOR
	}
	
	private YearName yearName;
	private ArrayList<Course> courses;
	
	public static SchoolYear createSchoolYear() {
		ArrayList<Course> schoolCourses = new ArrayList<Course>();
		
		Course english = new Course("English", Level.AE, new double[]{92.5, 94.0, 93.7, 92.4});
		Course math = new Course("Math", Level.AE, new double[]{92.5, 94.0, 93.7, 92.4});
		Course chem = new Course("Chem", Level.AE, new double[]{92.5, 94.0, 93.7, 92.4});
		Course history = new Course("History", Level.AE, new double[]{92.5, 94.0, 93.7, 92.4});
//		english.findLetterGrade();
		
		schoolCourses.add(english);
		schoolCourses.add(math);
		schoolCourses.add(chem);
		schoolCourses.add(history);
		
		SchoolYear freshman = new SchoolYear(YearName.FRESHMAN, schoolCourses);
		System.out.println("Freshman Year Grades:");
		freshman.getGPA();
		return freshman;
	}
	
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
			/*
			if (item.getLevel() == Level.H_AP) {
				courseGPA = letterGrade.getHonorGPA();
			} else if (item.getLevel() == Level.AE) {
				courseGPA = letterGrade.getAeGPA();
			} else if (item.getLevel() == Level.CP) {
				courseGPA = letterGrade.getCpGPA();
			} else if (item.getLevel() == Level.CP1){
				courseGPA = letterGrade.getCp1GPA();
			} else {
				System.out.println("Error");
			}
			*/
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
