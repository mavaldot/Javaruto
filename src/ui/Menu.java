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
		
		j.loadClans();
		
//		Clan c1 = new Clan("CLAN UCHIHA");
//		p(c1.listPersons());
//		
//		Person p1 = new Person("JOHAN", "Jf", "heyh", 1);
//		
//		c1.addPerson(p1);
//		p(c1.listPersons());
//		
//		Person p2 = new Person("NAHOJ", "FDFD", "fdg", 12);
//		c1.addPerson(p2);
//		
//		Person p3 = new Person("FDSF", "FD", "F", 5);
//		
//		c1.addPerson(p3);
//		
//		p(c1.listPersons());
//		
//		c1.sortByName();
//		
//		p(c1.listPersons());
		
		while (running) {
			
			
			p("\nWELCOME TO THE WORLD OF NARUTO\n");
			
			p("Please choose an option:");
			p("1. Create a new clan");
			p("2. Show clan list");
			p("3. Update a clan");
			p("4. Delete a clan");
			p("5. Order the clans");
			p("6. Display the clan menu");
			p("7. Exit\n");
			
			int choice = askInt(1,7);
			
			switch (choice) {
			
			case 1:
				
				String name = askString("Please enter the clan's name");
				
				if (j.findName(name)) {
					p("ERROR. A clan with that name already exists");
				}
				else {
					j.addClan(name);
					p("The clan was added successfully!");
				}
				
				break;
				
			case 2:
				
				p(j.listClans());
				break;
				
			case 3:
				
				String oldn = askString("Please enter the name of the clan you want to update");
				
				
				if (j.findName(oldn)) {
					
					String newn = askString("Please enter the clan's new name");
					
					if (j.findName(newn)) {
						p("ERROR. A clan with that name already exists");
					}
					else {
						j.updateClanName(oldn, newn);
						p("The clan was updated successfully");	
					}
				}
				else {
					p("ERROR. There is no clan with that name");
				}
					
				break;
				
			case 4:
				
				String delName = askString("Please enter the name of the clan you want to delete");
				
				if (j.deleteClan(delName))
					p("The clan was deleted successfully");
				else 
					p("ERROR. There is no clan with that name");
					
				break;
				
				
			case 5:
				
				j.orderClans();
				p("The clans have been ordered");
				int showlist = askInt("Do you want to see a list of the clans?\n1. Yes\n2. No", 1, 2);
				
				if(showlist == 1) {
					p(j.listClans());
				}
				
				break;
				
			case 6:
				
				String selClan = askString("Please enter the name of the clan you want to select");
				
				if (j.selectClan(selClan))
					clanMenu();
				else
					p("Could not find a clan with that name");
					
				break;
				
			case 7:
				running = false;
				p("Goodbye! :)");
				break;
				
			default:
					
				break;
			
			}
		}

	}
	
	public void clanMenu() {
		
		boolean running = true;
		
		while (running) {
			
			p("Welcome to the clan menu!\n");
			
			p("Current clan:");
			p(j.showClanInfo());
			
			p("\nPlease choose an option: ");
			p("1. Create a new person in this clan");
			p("2. List all of this clan's persons");
			p("3. Update a person in this clan");
			p("4. Delete a person in this clan");
			p("5. Order the persons");
			p("6. Display a person's menu");
			p("7. Exit the clan menu");
			
			int choice = askInt(1, 7);
			
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
				
			case 6:
				
				break;
				
			case 7: running = false; 
			
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
