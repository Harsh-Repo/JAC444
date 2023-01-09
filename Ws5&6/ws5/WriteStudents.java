import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 * A console log based class that serializes and writes students objects in a
 * file
 */
public class WriteStudents extends Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Main
	public static void main(String[] args) throws IOException {

		Student inputStudent = takeStudentInfoFromUser();

		saveStudentInfoToFile(inputStudent);

	}

	/**
	 * @param student
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void saveStudentInfoToFile(Student student) throws FileNotFoundException, IOException {

		// Write object to file
		File fileObj = new File("C:\\Users\\Harsh\\eclipse-workspace\\WS5&6\\src\\StudentInfo.txt");
		FileOutputStream fileOutputStreamObj = new FileOutputStream(fileObj, true);
		ObjectOutputStream outputStreamObj = new ObjectOutputStream(fileOutputStreamObj);
		outputStreamObj.writeObject(student);
		outputStreamObj.flush();
		outputStreamObj.close();
		fileOutputStreamObj.close();

		System.out.println("Object saved into file " + fileObj.getName());
		System.out.println("=======================================================");
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public static Student takeStudentInfoFromUser() throws IOException {

		System.out.println("=======================================================");

		// Create Student objects
		Student inputStudent = new Student();

		// Using Console to take student data from user
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// ID
		System.out.print("Enter Student Id: ");
		int stdID = Integer.parseInt(in.readLine());
		inputStudent.setStdID(stdID);

		// First Name
		System.out.print("Enter Student First Name: ");
		String firstName = in.readLine();
		inputStudent.setFirstName(firstName);

		// Last Name
		System.out.print("Enter Student Last Name: ");
		String lastName = in.readLine();
		inputStudent.setLastName(lastName);

		// Courses
		System.out.print("Enter Student Courses (separeted by coma \",\"): ");
		String coursesName = in.readLine();
		String[] courseArray = coursesName.split(",");
		for (int i = 0; i < courseArray.length; i++) {
			inputStudent.setCourses(courseArray[i]);
		}
		return inputStudent;
	}

}