import java.text.DecimalFormat; 

/**
 * This class creates objects of type Student
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca
 */

public class Student {
	
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	/**
	 * Constructor accepts 4 arguments
	 * @param firstName- string type for storing student's  first name
	 * @param lastName- string type for storing student's  last name
	 * @param grade- double type for storing student's grades 
	 * @param department- string type for storing department
	 */
	public Student(String firstName, String lastName, double grade, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	/** Setters */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/** Getters */
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	/**
	 * @return string; student full name
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * @return string, the student object
	 */
	@Override
	public String toString() {
		return " "+getFirstName() + "\t" + getLastName() + "\t\t" 
				+ new DecimalFormat("0.00").format(getGrade()) + "\t"
				+ getDepartment();
	}
	
	/**
	 * @param obj- A student object
	 * @return A boolean for, if student objects are equal
	 */
	public boolean equals(Student obj) {
		return this.getFirstName() == obj.getFirstName() && this.getLastName() == obj.getLastName()
			&& this.getGrade() == obj.getGrade() && this.getDepartment() == obj.getDepartment();
	}

}
