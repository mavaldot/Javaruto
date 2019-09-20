package ui;

import java.util.Scanner;

import model.Japan;

import model.Clan;
import model.Person;

public class Menu {

	private Scanner s;
	private Japan j;
	
	public Menu() {
		s = new Scanner(System.in);
		j = new Japan();
	}
	
	public void mainMenu() {
		
		boolean running = true;
		
		Clan c1 = new Clan("CLAN UCHIHA");
		p(c1.listPersons());
		
		Person p1 = new Person("JOHAN", "Jf", "heyh", 1);
		
		c1.addPerson(p1);
		p(c1.listPersons());
		
		Person p2 = new Person("NAHOJ", "FDFD", "fdg", 12);
		c1.addPerson(p2);
		
		Person p3 = new Person("FDSF", "FD", "F", 5);
		
		c1.addPerson(p3);
		
		p(c1.listPersons());
		
		c1.sortByName();
		
		p(c1.listPersons());
		
		while (running) {
			p("WELCOME TO THE WORLD OF NARUTO");
			
			p("Please choose an option:");
			p("1. Create a new clan");
			p("2. Show clan list");
			p("3. Update a clan");
			p("4. Delete a clan");
			p("5. Display the clan menu");
			p("6. Exit");
			
			int choice = askInt(1,6);
			p(choice);
			
			switch (choice) {
			
			case 1:
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6: running = false;
				break;
				
			default:
					
				break;
			
			}
		}

	}
	
	//prints an object t of type T on the screen
	public <T> void p(T t) {
		System.out.println(t);
	}
	
	public int askInt() {
		int ret = 0;
		try {
			String ans = s.nextLine();
			ret = Integer.parseInt(ans);
		}
		catch (NumberFormatException nfe) {
			System.out.println("ERROR. Please enter a number");
		}
		
		return ret;
	}
	
	public int askInt(String msg) {
		System.out.println(msg);
		int ret = 0;
		try {
			String ans = s.nextLine();
			ret = Integer.parseInt(ans);
		} 
		catch (NumberFormatException nfe) {
			System.out.println("ERROR. Please enter a number");
		}
		
		return ret;
	}
	
	public int askInt(String msg, int min, int max) {
		System.out.println(msg);
		int ret = 0;
		boolean success = false;
		
		while (!success) {
			
			try {
				
				String ans = s.nextLine();
				ret = Integer.parseInt(ans);
				
				if (ret < min || ret > max)
					System.out.println("ERROR. Please enter a number between " + min + " and " + max);
				else
					success = true;
					
			} 
			catch (NumberFormatException nfe) {
				System.out.println("ERROR. Please enter a number");
			}
		}
		
		return ret;
	}
	
	public int askInt(int min, int max) {
		int ret = 0;
		boolean success = false;
		
		while (!success) {
			
			try {
				
				String ans = s.nextLine();
				ret = Integer.parseInt(ans);
				
				if (ret < min || ret > max)
					System.out.println("ERROR. Please enter a number between " + min + " and " + max);
				else
					success = true;
					
			} 
			catch (NumberFormatException nfe) {
				System.out.println("ERROR. Please enter a NUMBER");
			}
		}
		
		return ret;
	}
	
	public String askString(String msg) {
		System.out.println(msg);
		String ret = s.nextLine();
		return ret;
	}
	
}
