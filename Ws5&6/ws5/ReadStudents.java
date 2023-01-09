import java.io.EOFException; 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** A console log based class that deserializes and reads students objects from a file */
public class ReadStudents extends Student {
	

	private static final long serialVersionUID = 1L;
	
	// Main
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			readStudentFromFile();
		}
 
	// Main
	public static void readStudentFromFile() throws IOException, ClassNotFoundException {
		
		System.out.println("=======================================================");
		// Read object from file
		File fileObj = new File("C:\\Users\\Harsh\\eclipse-workspace\\WS5&6\\src\\StudentInfo.txt");
		System.out.println("Reading Student Details From File " + fileObj.getName());
		FileInputStream fileInputStreamObj = new FileInputStream(fileObj);
		ObjectInputStream objInputStream = new ObjectInputStream(fileInputStreamObj);
		
		
		System.out.println("=======================================================");
		
		boolean keepReading = true;
        try {
            while(keepReading) {
            	// Create object from file
        		Student newStudent = (Student) objInputStream.readObject();
        		// Print Student data
        		System.out.println("Student Id : " + newStudent.getStdID());
        		System.out.println("Student First Name : " + newStudent.getFirstName());
        		System.out.println("Student Last Name : " +newStudent.getLastName());
        		System.out.println("Student Courses : " +newStudent.getCourses());
        		System.out.println("=======================================================");
        		objInputStream = new ObjectInputStream(fileInputStreamObj);

            }
        }catch(EOFException e) {
            keepReading = false;
        }
    	objInputStream.close();
	
}
}