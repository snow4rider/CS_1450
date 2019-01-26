/* Matthew McKenney
 * CS 1450 002
 * Assignment 02
 * September 6th, 2018
 * write code that creates a superclass of Character
 * and subclasses of: hero, villain, monster and droid.
 * */
package assignment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MmckenneAssignment2  {
	public static void main(String[] args) throws IOException {
		
		// reads file and initiates array
		Scanner input = new Scanner(new File("characters.txt"));
		int number = input.nextInt();
		Character[] characters = new Character[number];
						
		// Fills the array of characters with the subclasses
		for(int index = 0; index < characters.length; index++) {
			switch(input.next()) {
				case "h":{
					Character hero = new Hero(input.nextLine(),"hero"); 
					characters[index] = hero;
					break;
				}
				case "v":{
					Character villian = new Villian(input.nextLine(),"villian");
					characters[index] = villian;
					break;
				}
				case "m":{
					Character monster= new Monster(input.nextLine(),"monster");
					characters[index] = monster;
					break;
				}
				case "d":{
					Character droid = new Droid(input.nextLine(),"droid");
					characters[index] = droid;
					break;
				}
				default: {
					System.out.println("Invalid character");
				}
			}
		}
		
		//Prints the array of characters the name, type and statement  
		System.out.println("Character Name\t\t Type\t\tStatement");
		System.out.println("----------------------------------------------------------------------------");
		for(int index = 0; index < characters.length;index++) {
			System.out.printf("%s\t\t\t%s\t\t%s\n",
					characters[index].getType(), 
					characters[index].getName(), 
					characters[index].speak());
		}
        input.close();
	}
}//end main

// super class
class CharacterFall{
	private String name;
	private String type;
	
	public Character() {
		
	}
	public Character(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String speak() {
		return"";
	}
	
} // end of character class

//Hero class
class Hero extends Character{
	public Hero() {
		
	}
	public Hero(String name, String type){
		super(name, type);
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
		
	@Override
	public String speak() {
		return"To the rescue!  KAPOW!! BAM!! POW!!!";
	}
}

//Villain class
class Villian extends Character{
	public Villian() {
		
	}
	public Villian(String name, String type){
		super(name, type);
	}
	
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	
	@Override
	public String speak() {
		return"You'll Never Stop Me!  HAAAAAAA!!";
	}
}

//Monster class
class Monster extends Character{
	public Monster() {
		
	}
	public Monster (String name, String type){
		super(name, type);
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	
	@Override
	public String speak() {
		return"RRAAAUUGGHH GRROWR!!!";
	}
}

class Droid extends Character{
	public Droid() {
		
	}
	
	public Droid(String name, String type){
		super(name, type);
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	@Override
	public String speak() {
		return"Beep Beep Bloop Boop Beep!!!";
	}
}

