package com.hu.eric.gpa;

public class Course {

	public static enum Level {
		H_AP,
		AE,
		CP,
		CP1,
		UNLEVELED
		
	}
	
	public static enum LetterGrade {
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
	private double[] termScores;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] mathScores = {90.1, 89.2, 90.2, 88.9};
		Course math = new Course("Precalc", Level.AE, mathScores);
		System.out.println(math.toString());
		
		
	}
	
	public Course(String name, Level level, double[] termScores) {
		super();
		this.name = name;
		this.level = level;
		this.termScores = termScores;
	}
	
	public double getTermAvg() {
		double sum = 0;
		int totalTerms = 0;
		for (double item: termScores) {
			if (item == -1) {
				continue;
			}
			sum += item;
			totalTerms++;
		}
		double avg = sum/totalTerms;
		
		// combined two steps into one. this process is a two step round-up function.
		double fixedAvg = Math.round((Math.round(avg*100)/100.0)*10)/10.0;
		return fixedAvg;
	}
	
	public LetterGrade getLetterGrade() {
		long avg = Math.round(getTermAvg());
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public double[] getTermScores() {
		return termScores;
	}

	public void setTermScores(double[] termScores) {
		this.termScores = termScores;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "You created the " + name + " course, which is an " + level + " leveled class.";
	}
	
	

}
