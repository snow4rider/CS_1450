/* Matthew McKenney
 * CS 1450 002
 * Assignment 05
 * September 27th, 2018
 * create a generic class that takes two 
 * ordered stacks and merges them to one
 */
package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class MckenneyAssignment5 {
	public static void main(String[] args) throws IOException {
		
		// Name of file to read characters from
		final String FILE01 = "integers1.txt";
		final String FILE02 = "integers2.txt";
		
		//instansteate the mergestack
		
						
		// Setup the file reference variable to refer to the text file
		File inputFile01Name = new File(FILE01);
		File inputFile02Name = new File(FILE02);
		
		// Open the file for reading by creating a scanner for the file
		Scanner input01 = new Scanner (inputFile01Name);
		Scanner input02 = new Scanner (inputFile02Name);	
		
		//creates two empty stacks
		GenericStack<Integer> stack01 = new GenericStack<>();
		GenericStack<Integer> stack02 = new GenericStack<>();
		GenericStack<Integer> mergeStack = new GenericStack<>();
		
		//fills in the two stacks
		while (input01.hasNext()) {
			stack01.push(input01.nextInt()); 
		}
		
		while (input02.hasNext()) {
			stack02.push(input02.nextInt()); 
		}
		
		mergeStacks(stack01, stack02, mergeStack);
		
		//closes input 1 & 2
		input01.close();
		input02.close();
	}//end of main
	
	public static <E extends Comparable<E>> void mergeStacks (GenericStack<E> stack01, 
			GenericStack<E> stack02, GenericStack<E> mergedStack) {
		
		//compare the last values in each stack and load the lowest value
		//into the merged stack
		while( !stack01.isEmpty() && !stack02.isEmpty()) {
			if(stack01.peek().compareTo(stack02.peek()) < 0) {
				mergedStack.push(stack01.peek());
			}
			else {
				mergedStack.push(stack02.peek());
			}
		}//end of while loop
		
		if(stack01.isEmpty() && !stack02.isEmpty()) {
			mergedStack.push(stack02.peek());
		}
	} 


}//end of MckenneyAssignment5


class GenericStack<E>{
	private ArrayList<E> stack; 
	//private ArrayList<E> list;
	
	//Constructor that creates an empty stack(an empty ArrayList)
	public GenericStack (){
		stack = new ArrayList<>(); 
	}
	
	//returns the size of the stack
	public int getSize(){
		return stack.size();
	}
	
	//Indicates if the stack is empty
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	//returns the last element in the list to see it
	public  E peek(){
		return stack.get(stack.size()-1);
	}
	
	//add to the stack
	public void push(E value) {
		stack.add(value);
	}
	
	//removes the object on top of the stack
	public void pop() {
		stack.remove(stack.size()-1);
	}
	
}// end of GenericStack





