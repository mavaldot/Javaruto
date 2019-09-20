package ui;

import java.util.Scanner;

import model.Japan;

public class Menu {

	private Scanner s;
	private Japan j;
	
	public Menu() {
		s = new Scanner(System.in);
		j = new Japan();
	}
	
	public void mainMenu() {
		
		boolean running = true;
		
		while (running) {
			p("WELCOME TO THE WORLD OF NARUTO");
			
			p("Please choose an option:");
			p("");
			
			int choice = askInt(1,5);
			p(choice);
		}

	}
	
	//prints an object s of type T on the screen
	public <T> void p(T s) {
		System.out.println(s);
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
