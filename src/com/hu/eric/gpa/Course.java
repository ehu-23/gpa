package com.hu.eric.gpa;


/**
 * This class models a course, with a name, level, and term scores.
 * 
 * @author Eric Hu
 */
public class Course {
	
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
