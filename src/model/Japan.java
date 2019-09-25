package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Japan {
	
	private List<Clan> clans;
	private Clan selectedClan;
	private Person selectedPerson;
	private boolean ordered;
	
	
	public Japan() {
		clans = new ArrayList<Clan>();
		ordered = false;
	}
	
	public void loadClans() {
		
		File dir = new File("res");
		
		if (!dir.exists())
			dir.mkdir();
		
		File f = new File("res\\clans.se");
		
		try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			clans = (ArrayList<Clan>) in.readObject();
			in.close();
			
		} 
		catch (IOException e) {
			//e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
		

		
	}
	
	public void saveClans() {
		
		File dir = new File("res");
		
		if (!dir.exists())
			dir.mkdir();
		
		File f = new File("res\\clans.se");
		
		try {
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(clans);
			out.close();
			
		} 
		catch (IOException e) {
			
			//e.printStackTrace();
		}
	}
	
	public boolean findName(String name) {
		
		boolean found = false;
		
		for (int i = 0; i < clans.size() && !found; i++) {
			if (clans.get(i).getName().equals(name))
				found = true;
		}
		
		return found;
		
	}
	
	public void addClan(String name) {
		clans.add(new Clan(name));
		ordered = false;
		saveClans();
	}
	
	public String listClans() {
	
		String str = "";
		int i = 1;
		
		for(Clan c : clans) {
			str += "CLAN #" + i + "\n";
			str += c.showInfo() + "\n\n";
			i++;
		}
		
		return str;
		
	}
	
	public void updateClanName(String oldn, String newn) {
		
		boolean success = false;
		
		for (int i = 0; i < clans.size() && !success; i++) {
			if (clans.get(i).getName().equals(oldn)) {
				clans.get(i).setName(newn);
				success = true;
			}	
		
		}
		
		saveClans();
		
	}
	
	public boolean deleteClan(String delName) {
	
		boolean deleted = false;
		
		for (int i = 0; i < clans.size() && !deleted; i++) {
			if (clans.get(i).getName().equals(delName)) {
				clans.remove(i);
				deleted = true;
				saveClans();
			}	
		}
		
		return deleted;
	}
	
	public boolean selectClan(String selName) {
		
		boolean success = false;
		
		for (int i = 0; i < clans.size() && !success; i++) {
			if (clans.get(i).getName().equals(selName)) {
				selectedClan = clans.get(i);
				success = true;
			}	
		}
		
		return success;
		
	}
	
	public void orderClans() {
		
		if (!ordered) {
			
			for (int i = 0; i < clans.size() - 1; i++) {
				
				int index = i;
				Clan smallest = clans.get(i);
				
				for (int j = i; j < clans.size(); j++) {	
					if (smallest.compare(smallest, clans.get(j)) > 0) {
						smallest = clans.get(j);
						index = j;
					}	
		
				}
				if (index != i) {
					Clan tmp = clans.get(i);
					clans.set(i, smallest);
					clans.set(index, tmp);
				}	
			}
			
			ordered = true;
			saveClans();
			
		}

	}

	public String showClanInfo() {
		
		String ret = selectedClan.showInfo();
		
		return ret;
	}
	
	public void addPerson(String name, String personality, String creationDate, int power) {
		selectedClan.addPerson(new Person(name, personality, creationDate, power));
	}
	
	
}