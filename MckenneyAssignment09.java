/* By: Matthew McKenney
 * CS 1450 002
 * Assignment 09
 * November 13th, 2018
 * Description: Created a linked list of rail cars with data from a file. 
 * simulating a train from Chicago the train will remove rail cars based on the city destination or the frieght 
 * 	
 */

package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class MckenneyAssignment09 {
	public static void main(String[] args) throws IOException {
		
		//name of file to read from
		final String FILE_01 = "railcars.txt";
		
		// Setup the file reference variable to refer to the text file
		File inputFile01Name = new File(FILE_01);
		
		// Open the file for reading by creating a scanner for the file
		Scanner input01 = new Scanner (inputFile01Name);
		
		// Create a linked list for integers
		RailCarLinkedList newRailCarList  = new RailCarLinkedList();
		
		// while loop to read from the file and add them to the rail car 
		//then add them to the linked list
		while(input01.hasNext()) {
			int carNumber = input01.nextInt();
			String destination = input01.next();
			String freight = input01.next();
			RailCar newRailCar = new RailCar(carNumber, destination, freight);
			newRailCarList.addinSortedOrder(newRailCar);

		}//while
		
		
		System.out.println("Train Departs Chicago\n\nRailCar\tDestination City\t Freight");
		System.out.println("-----------------------------------------------");
		newRailCarList.printList();
		
		System.out.println("Stop 1: Train Arrives in Denver\r\n" + 
				"Remove: Denver rail cars\r\n");
		newRailCarList.removeCarWithDestination("DEN");
		System.out.println("RailCar\tDestination City\t Freight");
		System.out.println("-----------------------------------------------");
		newRailCarList.printList();
		
		System.out.println("\r\n" + 
				"Stop 2: Train Arrives in Colorado Springs\r\n" + 
				"Remove: Colorado Springs rail cars\r\n" + 
				"Remove: Rail cars with parrots\r\n");
		
		newRailCarList.removeCarsWithFreight("parrots");
		newRailCarList.removeCarWithDestination("COS");
		System.out.println("RailCar\tDestination City\t Freight");
		System.out.println("-----------------------------------------------");
		newRailCarList.printList();
		System.out.println("\n");
		
		System.out.println("Stop 3: Train Arrives in Pueblo\r\n" + 
				"Remove: Pueblo rail cars\r\n");
		newRailCarList.removeCarWithDestination("PBO");
		System.out.println("RailCar\tDestination City\t Freight");
		System.out.println("-----------------------------------------------");
		newRailCarList.printList();
		System.out.println("\n");
		
		System.out.println("Stop 4: Train Arrives in Santa Fe\r\n" + 
				"Remove: Santa Fe rail cars - train should be empty!\r\n");
		newRailCarList.removeCarWithDestination("SFE");
		System.out.println("RailCar\tDestination City\t Freight");
		System.out.println("-----------------------------------------------");
		newRailCarList.printList();
		System.out.println("\n");
		
		input01.close();
	}//end of main()

}//end of MckenneyAssignment9


class RailCar implements Comparable<RailCar>{
	private int carNumber;
	private String destination;
	private String freight;
	
	RailCar(int carNumber, String destination, String freight){
		this.carNumber = carNumber;
		this.destination = destination;
		this.freight = freight;
	}
	
	public String getFreight() {
		return freight;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String print(){
		String report = carNumber + " " + destination + " " + freight ;
		return report;
	}
	
	//compareTo
	@Override
	public int compareTo(RailCar other) {
		
		if(this.destination.equals(other.destination)) {
			return 0;
		}else if(this.destination.equals("DEN")) {
			return -1;
		}else if(this.destination.equals("COS")) {
			if(other.destination.equals("DEN")) {
				return 1;
			}else {
				return -1;
			}
		}else if(this.destination.equals("PBO")) {
			if(other.destination.equals("SFE")) {
				return -1; 
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}//compareTo
	
}//RailCar


class RailCarLinkedList{
	private Node head;
	
	
	RailCarLinkedList(){
		head = null;
	}
	
	
	//addinSortedOrder
	public void addinSortedOrder(RailCar railCarToAdd) {
		Node nodeRailCar = new Node(railCarToAdd);
		Node previous = null;
		Node current = head;
		
		if(head == null) {
			head = nodeRailCar;
		}else {
			boolean foundLocation = false;
			while (current != null && !foundLocation) {
				if(current.railCar.compareTo(railCarToAdd) == -1) {
					
					foundLocation = true;
					
				}else {
					//keep going
					previous = current;
					current = current.next;
				}
			}//while
			
			if(previous == null) {
				
				nodeRailCar.next = head;
				head = nodeRailCar;
			}else {
			
				//found insertion point
				previous.next = nodeRailCar;
				nodeRailCar.next = current;
			}	
		}
	}//addinSortedOrder
	
	
	//removeCarWithDestination
	public void removeCarWithDestination(String Destination) {
		while(head != null && head.railCar.getDestination().equals(Destination)) {
				head = head.next;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(current.railCar.getDestination().equals(Destination)) {
				previous.next = current.next;
				current = current.next;
			}
			else {
				previous = current;
				current = current.next;	
			}
		}
	}//removeCarWithDestination
	
	
	//removeCarsWithFreight
	public void removeCarsWithFreight(String freight) {
		
			
		while(head != null && head.railCar.getFreight().equals(freight)) {
				head = head.next;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(current.railCar.getFreight().equals(freight)) {
				previous.next = current.next;
				current = current.next;
			}
			else {
				previous = current;
				current = current.next;	
			}
		}
	}//removeCarWithFreight
	
	
	//print List
	public void printList() {
		Node current = head;
		
		if(head == null) {
			System.out.println("the list is empty!");
		}else {
			while(current != null) {
				System.out.println(current.railCar.print());
				current = current.next;
			}//while
		}
		
	}//print List
	
	
	
	
	//node inner class
	private class Node{
		private RailCar railCar;
		private Node next;
		
		//node constructor
		Node(RailCar railCar){
			this.railCar = railCar;
			next = null;
		}// node constructor 
	}//node inner class
}//RailCarLinkedList


