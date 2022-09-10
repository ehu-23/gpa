package com.hu.eric.gpa;

/**
 * This enum models a course letter grade. The associated values are weighted GPA values which depend on the course level.
 * 
 * @author Eric Hu
 *
 */
public enum LetterGrade {

//	Grade	(H/AP, AE,	 CP,   CP1 )	
	A_PLUS	(5.00, 4.50, 4.00, 3.50),
	A		(4.75, 4.25, 3.75, 3.25),
	A_MINUS	(4.50, 4.00, 3.50, 3.00),
	B_PLUS	(4.25, 3.75, 3.25, 2.75),
	B		(4.00, 3.50, 3.00, 2.50),
	B_MINUS	(3.75, 3.25, 3.75, 2.25),
	C_PLUS	(3.50, 3.00, 2.50, 2.00),
	C		(3.25, 2.75, 2.25, 1.75),
	C_MINUS (3.00, 2.50, 2.00, 1.50),
	D_PLUS	(2.75, 2.25, 1.75, 1.25),
	D		(2.50, 2.00, 1.50, 1.00),
	D_MINUS (2.25, 1.75, 1.25, 0.75),
	F		(0.00, 0.00, 0.00, 0.00);
	
	private double honorGPA;
	private double aeGPA;
	private double cpGPA;
	private double cp1GPA;
	
	/**
	 * This is the constructor
	 * 
	 * @param honorGPA Honors/AP GPA value
	 * @param aeGPA AE GPA value
	 * @param cpGPA CP GPA value
	 * @param cp1gpa CP1 GPA value
	 */
	private LetterGrade(double honorGPA, double aeGPA, double cpGPA, double cp1gpa) {
		this.honorGPA = honorGPA;
		this.aeGPA = aeGPA;
		this.cpGPA = cpGPA;
		this.cp1GPA = cp1gpa;
	}

	/**
	 * Gets Honors/AP GPA value
	 * 
	 * @return Honors/AP GPA value
	 */
	public double getHonorGPA() {
		return honorGPA;
	}

	/**
	 * Gets AE GPA value
	 * 
	 * @return AE GPA value
	 */
	public double getAeGPA() {
		return aeGPA;
	}
	
	/**
	 * Gets CP GPA value
	 * 
	 * @return CP GPA value
	 */
	public double getCpGPA() {
		return cpGPA;
	}

	/**
	 * Gets CP1 GPA value
	 * 
	 * @return CP1 GPA value
	 */
	public double getCp1GPA() {
		return cp1GPA;
	}
	
}


