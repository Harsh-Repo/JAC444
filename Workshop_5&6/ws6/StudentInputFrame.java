
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class StudentInputFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[]  args) {
		
		try {
		StudentInputFrame stdInput = new StudentInputFrame();

		JLabel Titlelabel = new JLabel("Add Student Information", SwingConstants.CENTER);

		Titlelabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		stdInput.getContentPane().add(Titlelabel);    


		JLabel StdNumberLabel = new JLabel("Student ID: ");
		StdNumberLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		stdInput.getContentPane().add(StdNumberLabel);
		JTextField StdNumberTextField = new JTextField(20);
		stdInput.getContentPane().add(StdNumberTextField);

		JLabel stdFirstNameLabel = new JLabel("First Name: ");
		stdFirstNameLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
		stdInput.getContentPane().add(stdFirstNameLabel);
		JTextField stdFirstNameTextField = new JTextField(20);
		stdInput.getContentPane().add(stdFirstNameTextField);

		JLabel stdLastNameLabel = new JLabel("Last Name: ");
		stdLastNameLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
		stdInput.getContentPane().add(stdLastNameLabel);
		JTextField stdLastNameTextField = new JTextField(20);
		stdInput.getContentPane().add(stdLastNameTextField);


		JLabel stdCoursesLabel = new JLabel("Courses: ");
		stdCoursesLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
		stdInput.getContentPane().add(stdCoursesLabel);
		JTextArea stdCoursesTextArea = new JTextArea(40, 20);
		stdInput.getContentPane().add(stdCoursesTextArea);


		JButton submit = new JButton("Submit");
		stdInput.getContentPane().add(submit);
			
		submit.addActionListener(
		         new ActionListener() // anonymous inner class
		         {   
		            // set text in textArea2 to selected text from textArea1
		            @Override
		            public void actionPerformed(ActionEvent event)
		            {


		        		try {

		        			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("StudentInfo.txt")));

		        			System.out.println("------->Please enter the Student's information<--------");
		        			@SuppressWarnings({ "resource", "unused" })
		        			Scanner scanner = new Scanner(System.in);



							
							
			
		        			
		        			int studentID = Integer.parseInt(StdNumberTextField.getText());
		        			String firstName = stdFirstNameTextField.getText();
		        			String lastName = stdLastNameTextField.getText();
		        			ArrayList<String> courses = new ArrayList<>(Arrays.asList(stdCoursesTextArea.getText().split("\n")));
		        			
		        			Student std = new Student(studentID, firstName, lastName, courses);
							
							oos.writeObject(std);
							StdNumberTextField.setText("");
							stdFirstNameTextField.setText("");
							stdLastNameTextField.setText("");
							stdCoursesTextArea.setText("");
													

		        			oos.close();
		        			

		        		} catch(FileNotFoundException e) {
		        			System.out.println(e.getMessage());
		        		} catch(IOException e) {
		        			System.out.println(e.getMessage()); 
		        		}catch(IllegalArgumentException e) {
		        			System.out.println( e.getMessage());	
		        		}
		        			
		        	

		            	
		            	
		            } 
		         } // end anonymous inner class
		      );

		
		/* *
		 * Button which will be used to read the object from file
		 * */
		JButton showStdData = new JButton("Show Students' data");
		stdInput.getContentPane().add(showStdData);

		showStdData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				StudentOutputFrame.read();
			}
		});

		stdInput.setLayout(new GridLayout(11,11,11,11));
		stdInput.setVisible(true);

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}


public StudentInputFrame() {
	setBounds(300, 100, 400, 500);
	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}

}