package com.hu.eric.gpa;


/**
 * This class models a course, with a name, level, and term scores.
 * 
 * @author Eric Hu
 */
public class Course {

	/**
	 * This enum models a course level.
	 */
	public static enum Level {
		H_AP, 		//Honors/AP 
		AE,			//Accelerated/Enriched
		CP,			//College Preparatory
		CP1,		//College Preparatory 1
		UNLEVELED	//Unleveled
		
	}
	
	/**
	 * This enum models a course letter grade. The associated values are weighted GPA values which depend on the course level.
	 */
	public static enum LetterGrade {
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
		
		private LetterGrade(double honorGPA, double aeGPA, double cpGPA, double cp1gpa) {
			this.honorGPA = honorGPA;
			this.aeGPA = aeGPA;
			this.cpGPA = cpGPA;
			this.cp1GPA = cp1gpa;
		}

		public double getHonorGPA() {
			return honorGPA;
		}

		public double getAeGPA() {
			return aeGPA;
		}

		public double getCpGPA() {
			return cpGPA;
		}

		public double getCp1GPA() {
			return cp1GPA;
		}
		
	}
	
	private String name;
	private Level level;
	private double credits;
	
	// If score is -1, it counts as no score.
	private double[] termScores;
	
	/**
	 * This is the course constructor
	 * 
	 * @param name course name
	 * @param level course level
	 * @param credits course credits
	 * @param termScores course term scores in array
	 */
	public Course(String name, Level level, double credits, double[] termScores) {
		super();
		this.name = name;
		this.level = level;
		this.credits = credits;
		this.termScores = termScores;
	}
	
	/**
	 * This method calculates the average score of a course.
	 * 
	 * @return the average score of the course
	 */
	public double getCourseAvg() {
		double sum = 0;
		int totalTerms = 0;
		for (double score: termScores) {
			//skips no score
			if (score == -1) {
				continue;
			}
			sum += score;
			totalTerms++;
		}
		double avg = sum/totalTerms;
		
		// combined two steps into one. this process is a two step round-up function.
		double fixedAvg = Math.round((Math.round(avg*100)/100.0)*10)/10.0;
		return fixedAvg;
	}
	
	/**
	 * This method calculates course letter grade based on score.
	 * 
	 * @return letter grade
	 */
	public LetterGrade getLetterGrade() {
		long avg = Math.round(getCourseAvg());
		if (avg >= 97) {
			return LetterGrade.A_PLUS;
		} else if (avg >= 93) {
			return LetterGrade.A;
		} else if (avg >= 90) {
			return LetterGrade.A_MINUS;
		} else if (avg >= 87) {
			return LetterGrade.B_PLUS;
		} else if (avg >= 83) {
			return LetterGrade.B;
		} else if (avg >= 80) {
			return LetterGrade.B_MINUS;
		} else if (avg >= 77) {
			return LetterGrade.C_PLUS;
		} else if (avg >= 73) {
			return LetterGrade.C;
		} else if (avg >= 70) {
			return LetterGrade.C_MINUS;
		} else if (avg >= 67) {
			return LetterGrade.D_PLUS;
		} else if (avg >= 63) {
			return LetterGrade.D;
		} else if (avg >= 60) {
			return LetterGrade.D_MINUS;
		} else {
			return LetterGrade.F;
		}
	}
	
	/**
	 * Gets course name.
	 * 
	 * @return course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets course name.
	 * 
	 * @param name course name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets course level.
	 * 
	 * @return course level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Sets course level.
	 * 
	 * @param level course level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Gets course term scores.
	 * 
	 * @return course term scores in array form
	 */
	public double[] getTermScores() {
		return termScores;
	}

	/**
	 * Sets course term scores
	 * 
	 * @param termScores course term scores in array form
	 */
	public void setTermScores(double[] termScores) {
		this.termScores = termScores;
	}

	@Override
	public String toString() {
		// Course: <name>, level: <level>, scores: <t1>, <t2>, <t3>, <t4>
		StringBuilder courseSummary = new StringBuilder(); 
		courseSummary.append("Course: " + name + ", ");
		courseSummary.append("Level: " + level + ", ");
		courseSummary.append("Credits: " + credits + ", ");
		courseSummary.append("Scores: ");
		for (int i = 0; i < termScores.length; i++) {
			courseSummary.append(termScores[i] + ", ");
			if (i == termScores.length-1) {
				courseSummary.append(termScores[i] + ".");
			}
		}
		return courseSummary.toString();
	}

	/**
	 * Gets course credits
	 * 
	 * @return course credits
	 */
	public double getCredits() {
		return credits;
	}

	/**
	 * Sets course credits
	 * 
	 * @param credits course credits
	 */
	public void setCredits(double credits) {
		this.credits = credits;
	}

}
