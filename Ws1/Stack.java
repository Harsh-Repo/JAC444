/*
Workshop#2
Seneca Id Number: 146315205
Name: Harsh Patel
Class: JAC444NAA
*/


/**
 *  
 * @author Harsh Patel
 *
 */
public class Stack{
	private char arr[];
	private int top;
	
	public Stack(int size) {  
		  arr= new char[size];
		  top= -1;
	}

	public boolean isEmpty(){
		return top == -1;	
	}
	
	public boolean isFull(){
		return top == arr.length - 1;
	}
		
	public void pushElement(char i) {
	    if (isFull()) {
	    	//throw new IllegalStateException("Stack is full");
	      }
	      arr[++top] = i;	    
	}
	
	public char popElement() {
	    if (isEmpty()) {
	      System.out.println("Stack is empty");
             //throw new IllegalStateException("Stack is empty");
	    }	    
	    return arr[top--];
	}
}
	
	