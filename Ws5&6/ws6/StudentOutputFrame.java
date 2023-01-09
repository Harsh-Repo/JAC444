import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;



public class StudentOutputFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void read() {
	
		StudentOutputFrame frame = new StudentOutputFrame();
		
		try {
			FileInputStream fis = new FileInputStream(new File("StudentInfo.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Student std = (Student) ois.readObject();
			
			
		
					
			String studentIDStr = Integer.toString(std.getStudentID());
	
				
			JLabel textLabel = new JLabel("Students Information", SwingConstants.CENTER);
		   	textLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		    frame.getContentPane().add(textLabel);
					
			JTextArea textArea = new JTextArea(10, 20);
			textArea.append("Student ID : " + studentIDStr + "\n");
			textArea.append("FirstName : " + std.getStudenFirstName() + "\n");
			textArea.append("LastName : " + std.getStudenLastName() + "\n");
			textArea.append("Courses : ");
			for(String a : std.getStudentCourses()){
				   textArea.append(a + "\n");
				}
		
				
			frame.add(textArea);
			frame.setLayout(new FlowLayout());
	
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public StudentOutputFrame() {
		setBounds(700, 250, 250, 200);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}