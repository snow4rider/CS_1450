/* Matthew McKenney
 * CS 1450 002
 * Assignment 03
 * September 13th, 2018
 * write code that creates an abstract class of Bird
 * and concrete classes of: Penguin, Ostrich, Duck, Sooty_Tern, Loon, and Humming Bird.
 */

package assignment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MckenneyAssignment3 {
	public static void main(String[] args) throws IOException {
		
		// reads file and initiates array
		Scanner input = new Scanner(new File("birds.txt"));
		int number = input.nextInt();
		Bird[] flock = new Bird[number];
		
		
		// Fills the array of characters with the subclasses
		for(int index = 0; index < flock.length; index++) {
			switch(input.next()) {
				case "p":{
					
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Penguin(name, run, swim);
					break;
				}
				case "o":{
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Ostrich(name, run, swim);
					break;
				}
				case "d":{
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Duck(name, swim, run, fly);
					break;
				}
				case "s":{
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Sooty_Tern(name, run,fly);
					break;
				}
				case "l":{
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Loon(name, fly, swim);
					break;
				}
				case "h":{
					String name = input.next();
					int run = input.nextInt();
					int swim = input.nextInt();
					int fly = input.nextInt();
					flock[index] = new Humming_Bird(name, fly);
					break;
				}
				default: {
					System.out.println("Invalid character");
				}
			}// end of switch case
		}// end of for loop
		for(int index = 0; index < flock.length;index++) {
			System.out.printf("%s\t\t%s\n",
					flock[index].getType(), 
					flock[index].getName());
			}
		
		
		input.close();
	}// end of main
	public static ArrayList<Bird> findCannotFly(Bird[] flock){
		ArrayList<Bird> cannotFly = new ArrayList<Bird>();
		for(int index = 0; index < flock.length; index++) {
			
				cannotFly.add(flock[index]);
		}
		return cannotFly;
	}
	
}

abstract class Bird{
	private String name;
	private String type;
	
	public Bird() {
		
	}
	public Bird(String name, String type) {
		this.setName(name);
		this.setType(type);
	}
	abstract void interestingFact();
	//return the name 
	public String getName() {
		return name;
	}
	//set name to name
	public void setName(String name) {
		this.name = name;
	}
	 //return the type
	public String getType() {
		return type;
	}
	//set type to type
	public void setType(String type) {
		this.type = type;
	}
}

class Penguin extends Bird implements Swim, Run{
	private int run, swim;
	public Penguin(String name, int run, int swim) {
		super(name, "Penguin");
		this.run = run;
		this.swim = swim;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getSwim() {
		return this.swim;
	}
	public int getRun() {
		return this.run;
	}
	@Override
	void interestingFact() { 
		System.out.println("I can’t fly but I’m the fastest "
				+ "swimmer and deepest diver of "
				+ "any bird and can stay underwater up to 20 minutes.");
	}
	@Override
	public void runSpeed() {
		System.out.println(this.run);	
	}
	@Override
	public void swimSpeed() {
		System.out.println(this.swim);	
	}
}//end of penguin class

class Ostrich extends Bird implements Swim, Run{
	private int run, swim;
	public Ostrich(String name, int run, int swim) {
		super(name, "Ostrich");
		this.run = run;
		this.swim = swim;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getSwim() {
		return this.swim;
	}
	public int getRun() {
		return this.run;
	}
	@Override
	void interestingFact() {
		// 
		System.out.println("Who needs flying when "
				+ "you’re the biggest bird on earth! I can"
				+ " grow up to 9 feet tall and weigh as"
				+ " much as 300 pounds! Don't mess with me!");
	}
	@Override
	public void runSpeed() {
		System.out.println(this.run);	
	}
	@Override
	public void swimSpeed() {
		System.out.println(this.swim);	
	}
}// end of Ostrich

class Duck extends Bird implements Swim, Run, Fly{
	private int swim, run, fly;
	public Duck(String name,int swim, int run, int fly ) {
		super(name, "Duck");
		this.swim = swim;
		this.run = run;
		this.fly = fly;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getSwim() {
		return this.swim;
	}
	public int getRun() {
		return this.run;
	}
	public int getFly() {
		return this.fly;
	}
	@Override
	void interestingFact() {
		// 
		System.out.println("A duck's highest documented flight"
				+ " was over Nevada where a plane"
				+ " struck a mallard at 21,000 feet!");
	}
	@Override
	public void flySpeed() {
		System.out.println(this.fly);
	}
	@Override
	public void runSpeed() {
		System.out.println(this.run);
	}
	@Override
	public void swimSpeed() {
		System.out.println(this.swim);
	}
}// end of Duck

class Sooty_Tern extends Bird implements Run, Fly{
	private int run, fly;
	public Sooty_Tern(String name, int run, int fly) {
		super(name, "Sooty_Tern");
		this.run = run;
		this.fly = fly;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getRun() {
		return this.run;
	}
	public int getFly() {
		return this.fly;
	}
	@Override
	void interestingFact() {
		System.out.println("Strange as it may sound,"
				+ " I spend most of my life at sea "
				+ "and yet I can't swim! I also take "
				+ "1 to 2 second naps while flying! ");
	}
	@Override
	public void flySpeed() {
		System.out.println(this.fly);
	}
	@Override
	public void runSpeed() {
		System.out.println(this.run);
	}
}// end of Sooty_Tern

class Loon extends Bird implements Fly, Swim{
	private int fly;
	private int swim;
	public Loon(String name, int fly, int swim) {
		super(name, "Loon");
		this.fly = fly;
		this.swim = swim;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getFly() {
		return this.fly;
	}
	public int getSwim() {
		return this.swim;
	}
	@Override
	void interestingFact() {
		System.out.println("My legs are so far back"
				+ " on my body that I cannot walk"
				+ " on land, instead I push myself "
				+ "along the ground on my chest.");
	}
	@Override
	public void swimSpeed() {
		System.out.println(this.swim);
	}
	@Override
	public void flySpeed() {
		System.out.println(this.fly);
	}
}// end of Loon

class Humming_Bird extends Bird implements Fly{
	private int fly;
	public Humming_Bird(String name, int fly) {
		super(name, "Humming Bird");
		this.fly = fly;
	}
	public String getName() {
		return super.getName();
	}
	public String getType() {
		return super.getType();
	}
	public int getFly() {
		return this.fly;
	}
	@Override
	void interestingFact() {
		System.out.println("My feet are so small "
				+ "and my flying so adept!  I've got"
				+ " the fastest beating heart in the "
				+ "animal kingdom with heart rates exceeding "
				+ "1,200 beats per minute.");
	}
	@Override
	public void flySpeed() {
		System.out.println(this.fly);
	}
}// end of Humming_Bird

interface Swim{
	 void swimSpeed();
}
interface Run{
	void runSpeed();
}
interface Fly{
	void flySpeed();
}