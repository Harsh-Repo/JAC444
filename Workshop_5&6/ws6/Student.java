

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class Student is Serializable.
 * It has the following constructor, getters and setters.
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	/**
	 * Constructor for Student
	 * @param stdID  integer Student ID
	 * @param firstName String Student first name
	 * @param lastName String Student last name
	 * @param courses String array for this Student
	 */
	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}
	/**
	 * 	 * @return integer student ID
	 */
	public int getStudentID() {
		return stdID;
	}
	/**
	 * set the student ID
	 * @param stdID integer
	 */
	public void setStudentID(int stdID) throws IllegalAccessException{
		if(stdID <0)
			throw new IllegalArgumentException("Student ID should be a positive integer!");
		this.stdID = stdID;
	}
	/**
	 * @return String for Student's first name
	 */
	public String getStudenFirstName() {
		return firstName;
	}
	
	/**
	 * @return String for Student's last name
	 */
	public String getStudenLastName() {
		return lastName;
	}
	
	public ArrayList<String> getStudentCourses() {	
		return courses;
	}
	
	
	
	
	
}