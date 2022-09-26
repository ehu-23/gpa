package com.hu.eric.gpa;

/**
 * This class models a student, which includes a name and year grades
 * 
 * @author Eric Hu
 *
 */
public class Student {
	
	private String name;
	private SchoolYear[] yearGrades;
	
	/**
	 * This is the constructor
	 * 
	 * @param name student name
	 */
	public Student(String name) {
		this.name = name;
		this.yearGrades = new SchoolYear[4];
	}
	
	/**
	 * Gets weighted GPA from student information
	 * 
	 * @return weighted GPA
	 */
	public double getWeightedGPA() {
		double totalGPA = 0.0;
		double totalCredits = 0.0;
		for (SchoolYear schoolYear: this.yearGrades) {
			if (schoolYear==null) {
				continue;
			}
			double yearGPA = 0.0;
			double yearCredits = 0.0;
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
				yearCredits += course.getCredits();
				yearGPA += courseGPA*course.getCredits();
				totalCredits += course.getCredits();
				totalGPA += courseGPA*course.getCredits();
				//System.out.println(course.getName() + "\t\t" + course.getCourseAvg() + "\t\t" + course.getLetterGrade());
			}
			System.out.println(this.getName() + "'s " + schoolYear.getYearName() + " weighted GPA is: " + yearGPA/yearCredits);
		}
		
		return totalGPA/totalCredits;
		
	}

	/**
	 * Adds school year
	 * 
	 * @param year school year
	 */
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
		yearGrades[index] = year;
	}
	
	/**
	 * Gets student name
	 * 
	 * @return student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets student name
	 * 
	 * @param name student name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets student year grades
	 * 
	 * @return student year grades
	 */
	public SchoolYear[] getYearGrades() {
		return yearGrades;
	}

	/**
	 * Sets student year grades
	 * 
	 * @param grades student year grades
	 */
	public void setYearGrades(SchoolYear[] grades) {
		this.yearGrades = grades;
	}

}
