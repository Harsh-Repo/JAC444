import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


/**
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca
 */
public class StudentProcess {
	
	
	private static Student[] students = {
			 new Student("Jack", "Smith", 50.0, "IT"),
			 new Student("Aaron", "Johnson", 76.0, "IT"),
			 new Student("Maaria", "White", 35.8, "Business"),
			 new Student("John", "White", 47.0, "Media"),
			 new Student("Laney", "White", 62.0, "IT"),
			 new Student("Jack", "Jones", 32.9, "Business"),
			 new Student("Wesley", "Jones", 42.89, "Media")
			 };
	

	public static void main(String[] args) {
		
		/** Task 1 */
		List<Student> list = task1();
		
		/** Task 2 */
		task2(list);
		
		/** Task 3 */
		task3(list);
		
		/** Task 4 */
		task4(list);
		
		/** Task 5 */
		task5(list);
		
	}


	/**
	 * Task:1 This method display student list
	 * @return
	 */
	public static List<Student> task1() {
		System.out.println("Task 1:\n");
		System.out.println("Complete Student list:");
		List<Student> list = Arrays.asList(students);
		list.forEach(System.out::println);
		return list;
	}
	

	/**
	 * Task 2: This method filter studentslist based on grade range and display them in sorted order
	 * @param list
	 */
	public static void task2(List<Student> list) {
		System.out.println("\n\nTask 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		list.stream()
			.filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
			.sorted(Comparator.comparing(Student::getGrade))
			.forEach(System.out::println);
	}
	
	/**
	 * Task:3 This method filter studnetslist based on grade range and display the first student
	 * @param list
	 */
	public static void task3(List<Student> list) {
		System.out.println("\n\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		Optional<Student> student = list.stream()
			.filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
			.findFirst();
		System.out.println(student.get());
	}
	

	/**
	 * Task4: This method Sort the Students and display them. 
	 * @param list
	 */
	public static void task4(List<Student> list) {
		System.out.println("\n\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		list.stream()
			.sorted(Comparator.comparing(Student::getFirstName))
			.sorted(Comparator.comparing(Student::getLastName))
			.forEach(System.out::println);
		
		System.out.println("\nStudents in descending order by last name then first:");
		list.stream()
			.sorted(Comparator.comparing(Student::getFirstName).reversed())
			.sorted(Comparator.comparing(Student::getLastName).reversed())
			.forEach(System.out::println);
	}
	

	/**
	 * Task5 : This method display unique Student last names in sorted order.
	 * @param list
	 */
	public static void task5(List<Student> list) {
		System.out.println("\n\nTask 5:\n");
		System.out.println("Unique Student last names:");
		list.stream()
			.sorted(Comparator.comparing(Student::getLastName))
			.map(Student::getLastName)
			.distinct()
			.forEach(System.out::println);
	}

}