/*
Workshop#2
Seneca Id Number: 146315205
Name: Harsh Patel
Class: JAC444NAA
*/

import java.util.Scanner;

/**
 *  @author Harsh Patel
 *
 */
public class Palindrome{
	
	/**
	 * 
	 * @param input
	 * @return temporary string result
	 */
	public static String reverseInput(String input) {
		Stack stack = new Stack(100);
		
		String temp = "";
		
		for(int i=0; i<input.length();i++) {
			stack.pushElement(input.charAt(i));	
		}
		
		while (!stack.isEmpty()){
			temp = temp + stack.popElement();
		}
		
		return temp;		
	}
	
	/**
	 * This will print final result of given input
	 * @param str
	 */
	public static void checkPalindrome(String str){
		
		String reversedInput = reverseInput(str);
				
	  if(reversedInput.equals(str)){ 
		  System.out.println( str + " is a palindrome.");
	  }
	  
	  else{
		  System.out.println( str + " is not a palindrome.");
	  }
	}
	
	/**
	 * This method take input from user and check for Palindrome.
	 */
	public static void main(String[] args) {	
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter your string or number:");		 
			 String input = scanner.nextLine();		 
			 checkPalindrome(input);
		}
	}

}



