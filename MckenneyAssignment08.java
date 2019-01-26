/* Matthew McKenney
 * CS 1450 002
 * Assignment 08
 * October 30th, 2018
 * write a program to decode a message that has been split into three parts.\
 * The three parts are provided in three different files.
 */

package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MckenneyAssignment8 {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Name of file to read characters from
		final String FILE01 = "arrayKey.txt";
		final String FILE02 = "arrayMessage1.txt";
		final String FILE03 = "arrayMessage2.txt";
		final String FILE04 = "queueKey.txt";
		final String FILE05 = "queueMessage1.txt";
		final String FILE06 = "queueMessage2.txt";
		
		
		// Setup the file reference variable to refer to the text file
		File inputFile01Name = new File(FILE01);
		File inputFile02Name = new File(FILE02);
		File inputFile03Name = new File(FILE03);
		File inputFile04Name = new File(FILE04);
		File inputFile05Name = new File(FILE05);
		File inputFile06Name = new File(FILE06);
				
		// Open the file for reading by creating a scanner for the file
		Scanner input01 = new Scanner (inputFile01Name);
		Scanner input02 = new Scanner (inputFile02Name);	
		Scanner input03 = new Scanner (inputFile03Name);
		Scanner input04 = new Scanner (inputFile04Name);	
		Scanner input05 = new Scanner (inputFile05Name);
		Scanner input06 = new Scanner (inputFile06Name);	
		
		//create three ArrayList
		ArrayList<Integer> arrayKey = new ArrayList<>();
		ArrayList<Character> arrayMessage1 = new ArrayList<>();
		ArrayList<Integer> arrayMessage2 = new ArrayList<>();
		
		
		//create three queues 
		Queue<Integer> queueKey = new LinkedList<>();
		Queue<Character> queueMessage1 = new LinkedList<>();
		Queue<Integer> queueMessage2 = new LinkedList<>();
		
		
		//for loop to load ArrayList with arrayKey
		int keyArray = input01.nextInt();
		for(int i = 0; i < keyArray; i++) {
			arrayKey.add(input01.nextInt());
		}
		
		//for loop to load ArrayList with arrayMessage1
		String message01 = input02.nextLine();
		for(int i = 0; i < message01.length(); i++) {
			arrayMessage1.add(message01.charAt(i));
		}
		
		//for loop to load ArrayList with arrayMessage2
		int messageArray = input03.nextInt();
		for(int i = 0;i < messageArray; i++) {
			arrayMessage2.add(input03.nextInt());	
		}
		
		
		//for loop to load a Queue with queueKey
		int queueky = input04.nextInt();
		for(int i = 0; i < queueky; i++) {
			queueKey.offer(input04.nextInt());
		}
		
		//for loop to load queue with queueMessage1
		String qMessage01 = input05.nextLine();
		for(int i = 0;i < qMessage01.length(); i++) {
			queueMessage1.offer(qMessage01.charAt(i));
		}
		
		
		//for loop to load queue with queueMessage2
		int qMessage02 = input06.nextInt(); 
		for(int i = 0;i < qMessage02;i++) {
			queueMessage2.offer(input06.nextInt());
		}
		
		
		//translator instantiating
		Translator trans = new Translator();
		
		//Iterators for the ArrayList
		Iterator<Character> msg1Iterator = arrayMessage1.iterator();
		Iterator<Integer> msg2Iterator = arrayMessage2.iterator();
		Iterator<Integer> keyIterator = arrayKey.iterator();
		
		//Iterators for the queue
		Iterator<Character> qmsg1Iterator = queueMessage1.iterator();
		Iterator<Integer> qmsg2Iterator = queueMessage2.iterator();
		Iterator<Integer> qKeyIterator = queueKey.iterator();
		
		
		
		String messagecode = trans.decode(msg1Iterator, msg2Iterator, keyIterator);
		String qmessagecode = trans.decode(qmsg1Iterator, qmsg2Iterator, qKeyIterator);
		
		System.out.println(messagecode + "\n" + qmessagecode);
		
		
		input01.close();
		input02.close();
		input03.close();
		input04.close();
		input05.close();
		input06.close();
	}
}//end of MckenneyAssignment8


//class that translates secret messages
class Translator{
	private Stack stack;
	
	Translator(){
		stack = new Stack();
	}
	
	
	public String decode(Iterator<Character> msg1Iterator, 
						 Iterator<Integer> msg2Iterator, 
						 Iterator<Integer> keyIterator) {
		
		
		while(keyIterator.hasNext()) {
			int key = keyIterator.next();
			
			if(key == 0) {
				char msg1 = msg1Iterator.next();
				stack.push(msg1);
			}else {
				int msg2 = msg2Iterator.next();
				stack.push((char)msg2);
			}
		}//end of while
		
		String code = "";
		while(!stack.isEmpty()) {
			code = code + stack.pop();
		}
		return code;
	} 
}//end of Translator


class Stack{
	private ArrayList<Character> list;
	
	Stack(){
		list = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public void push(Character value) {
		list.add(value);
	}
	
	public Character pop() {
		Character value = list.get(list.size()-1);
		list.remove(list.size()-1);
		return value;
	}
}//end of Stack