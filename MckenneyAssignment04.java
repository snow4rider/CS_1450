/* Matthew McKenney
 * CS 1450 002
 * Assignment 03
 * September 20th, 2018
 * write code that creates an abstract class of Bird
 * and concrete classes of: Penguin, Ostrich, Duck, Sooty_Tern, Loon, and Humming Bird.
 */

package assignment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MckenneyAssignment4 {
	public static void main(String[] args) throws IOException {
		
		// Name of file to read characters from
		final String FILE = "SortingYardTrains7.txt";
		
		// Setup the file reference variable to refer to the text file
		File inputFileName = new File(FILE);
		
		// Open the file for reading by creating a scanner for the file
		// Read the first value in the file, it indicates how many tracks the yard has
		Scanner input = new Scanner (inputFileName);
		int numTracks = input.nextInt();
		
		
		//instantiate rail yard class
		RailYard railyard = new RailYard (numTracks + 1);
		
		
		//while loop to read details from file
		//create a train and add to sorting yard
		//print details
		while(input.hasNext()) {
			
			//reads from file and loads information into local var
			int trackNum = input.nextInt();
			int engineNum = input.nextInt();
			String companyName = input.next();
			int maxNumRailCars = input.nextInt();
			String destination = input.next();
			
			//creates train object
			Train train = new Train(engineNum,companyName, maxNumRailCars, destination);
			
			//adds to railyard array
			railyard.addTrainTosortingYard(trackNum, train);
			
			//print train details
			System.out.print("Loading sorting track " + trackNum + ":");
			System.out.println(" " + train.print());
			
		}//end of while loop
		
		input.close();
	}// end of main method

	
}// Assignment 4

class RailYard{
	private int numTrack;
	private int currentTrack;
	Train[] sortingYard;
	
	// constructor to fill number of tracks
	RailYard(int numTrack){
		this.numTrack = numTrack;
		currentTrack = 0;
		sortingYard = new Train[this.numTrack];
	}
	public int getCurrentTrack() {
		return this.currentTrack;
	}
	
	//adds train to array sortingYard
	public void addTrainTosortingYard(int trackNumber, Train train){
		sortingYard[trackNumber] = train;
	}
	
	//iterates through the sorting array
	public Train getNextTraininSortingYard(){
		Train aTrain = sortingYard[currentTrack];
		currentTrack++;
		return aTrain;
	}
}//end of RailYard


class Train{
	private int engineNumber;
	private String companyName;
	private int numberOfRailCars;
	private String destinationCity;
	
	
	//constructor that sets all the private data fields
	public Train(int engineNumber,String companyName, int numberOfRailCars, String destinationCity) {
		this.engineNumber = engineNumber;
		this.companyName = companyName;
		this.numberOfRailCars = numberOfRailCars;
		this.destinationCity = destinationCity;
	}
	
	//getter for engineNumber
	public int getEngineNumber() {
		return this.engineNumber;
	}
	
	//getter for companyName
	public String getCompanyName() {
		return this.companyName;
	} 
	
	//getter for numberOfRailCars
	public int getNumberOfRailCars(){
		return this.numberOfRailCars;
	}
	
	//getter for destinationCity
	public String getDestinationCity(){
		return this.destinationCity;
	}
	
	//prints string of engine #, company name, # of rail cars, and destination
	public String print(){
		
		return String.format("%9d\t%-5s\t\t%-3d\t\t%-15s",
				this.engineNumber, 
				this.companyName,  
				this.numberOfRailCars, 
				this.destinationCity);
	}
}//end of Train


//reports one out bound train
class OutboundReport{
	private int trackNumber;
	private int engineNumber;
	private int numRailCars;
	private String destCity;
	
	//constructor to set private data
	public OutboundReport(int trackNumber, int engineNumber, int numberRailCars, String destinationCity) {
		this.trackNumber = trackNumber;
		this.engineNumber = engineNumber;
		this.numRailCars = numberRailCars;
		this.destCity = destinationCity;
	}
	
	public static void printOutboundReport(RailYard yard) {
		
		
	}
	
	//prints string of track #, engine # , # of rail cars, and destination
	public String print(){
		return String.format("%9d\t%-5s\t\t%-3d\t\t%-15s",
				this.trackNumber, 
				this.engineNumber,  
				this.numRailCars, 
				this.destCity);
		}
	
	//compare trains
	public int compareTo(int numRailCars) {
		return 0;
	}
}//end of OutboundReport class