/* Matthew McKenney
 * CS 1450 002
 * Assignment 01
 * Thursday August 30, 2018
 * Write a random number generator [0-99] and store them in an array. 
 * Display the array and perform calculations like sum, average, median, and mode.
 * Then write the ordered array to a file and then read the file printing it to the console
 * */


package assignment;
import java.util.Scanner;

public class mmckenneAssignment1 {
	public static void main(String[] arg) throws java.io.IOException{
		
		// declare variables 
		int[] randNumberArray = new int[25];
		
		// Fill the array with random numbers
		for (int index = 0; index < randNumberArray.length; index++) {
			int randomNumber = (int)(Math.random() * 100);
			randNumberArray[index] = randomNumber;
		}
		
		//print array
		for (int index = 0; index < randNumberArray.length; index++) {
			System.out.println(randNumberArray[index]);
		}
		
		double sum = sum(randNumberArray);
		double ave = average(randNumberArray, sum);
		bubbleSort(randNumberArray);
		int med = randNumberArray[median(randNumberArray)];
		int mo = mode(randNumberArray);
		
		System.out.printf("Sum\t\t= %.2f\nAverage\t\t= %.2f\nMedian\t\t= %d\nMode value\t= %d\n",sum,ave,med,mo);
		
		java.io.File file = new java .io.File("assignments1.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		//prints to file
		for (int index = 0; index < randNumberArray.length; index++) {
			output.println(randNumberArray[index]);
		}
		
		// close the file
		output.close();
		
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
			int number = input.nextInt();
			System.out.println(number);
		}
		input.close();	
	}
	
	// Sums up the array
	static double sum(int[] randNumberArray) {
		double sum = 0.0;
		for(int index : randNumberArray ) {
			sum += index;
		}
		return sum;
	}
	
	// calculates the average of the array
	static double average(int[] randNumberArray, double sum) {
		double average = sum / randNumberArray.length;
		return average; 
	}
	// Calculates the median of the Array
	static int median(int[] randNumberArray) {
		int middle = (int)randNumberArray.length/2;
		return middle;
	}
	
	// Sorts the array using a bubble sort
	static void bubbleSort(int[] randNumberArray) {
		int temp; 
		int l = randNumberArray.length;
	    
		  for (int k = 1; k < l; k++) {			  
			  for (int i = 0; i < l - k; i++) {
				  if (randNumberArray [i] > randNumberArray [i + 1]) {
					  temp = randNumberArray [i];
					  randNumberArray [i] = randNumberArray [i + 1];
					  randNumberArray[ i + 1] = temp;
				  } 				  
			  }
		  }
	}
	 
	// Calculates the mean of the array
	static int mode(int[] randNumberArray) {
		int mode = randNumberArray[0];
		int maxCount = 0;
		int l = randNumberArray.length;
		for(int i = 0; i < l; i++) {
			int value = randNumberArray[i];
			int count = 1;
			for(int j = 0; j < l; j++) {
				if (randNumberArray[j] == value) {
					count++;
				}
				if(count > maxCount) {
					mode = value;
					maxCount = count;
				}
			}
		}
		return mode;
	}
}
