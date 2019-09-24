package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Comparator<Clan>, Serializable {

	private String name;
	private Person first;
	
	public Clan(String nam) {
		name = nam;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Person getFirst() {
		return first;
	}
	
	public void setFirst(Person p) {
		first = p;
	}
	
	public String showInfo() {
		String info = name;
		return info;
	}
	
	
	public boolean addPerson(Person p) {
		
		boolean success = false;
		
		if (!findName(p.getName())) {
			
			if (first == null) {
				first = p;
				success = true;
			}
			else {
				insertAfter(first, p);
				success = true;
			}
		}
		
		return success;
		
	}
	
	public String listPersons() {
		
		String str = "";
		
		if (first != null) {
			str += first.toString();
			
			Person next = first.getNext();
			
			while (next != null) {
				str += next.toString();
				next = next.getNext();
			}
		}
		
		return str;
		
	}
	
//	public boolean addPerson(Person p) {
//		
//		boolean success = false;
//		
//		if (!findName(p.getName())) {
//
//			if (first == null) {
//				first = p;
//				success = true;
//			} 
//			else {
//				
//				Person next = first.getNext();
//				
//				while(!success) {
//
//					if (next == null) {
//						insertAfter(first, p);
//					}
//					else {
//						
//					}
//					
//				}
//				
//
//			}
//		}
//		
//
//	}
	
	public boolean findName(String name) {
		
		boolean found = false;
		
		if (first != null) {
			
			if (first.getName().equals(name)) {
				found = true;
			}
			
			Person next = first.getNext();
			
			while (next != null && !found) {
				
				if (next.getName().equals(name))
					found = true;
				
				next = next.getNext();
			}
			
		}
		
		return found;
		
	}
	
	public void insertAfter(Person p1, Person p2) {
		Person next = p1.getNext();
		p1.setNext(p2);
		p2.setPrev(p1);
		p2.setNext(next);
	}
	
	public void swap(Person p1, Person p2) {
		
		Person prev = p1.getPrev();
		Person next = p2.getNext();
		
		if (p1.equals(first))
			first = p2;	

		p2.setPrev(prev);
		p2.setNext(p1);
		p1.setPrev(p2);
		p1.setNext(next);
	}
	
	public void change(Person p1, Person p2) {
		
		if(p1.getNext().equals(p2))
			swap(p1,p2);
		else if(p2.getNext().equals(p1))
			swap(p2,p1);
		else {
			
			Person prevP1 = p1.getPrev();
			Person nextP1 = p1.getNext();

			p1.setPrev(p2.getPrev());
			p1.setNext(p2.getNext());
			p2.setPrev(prevP1);
			p2.setNext(nextP1);
			
			if (p1.equals(first))
				first = p2;	
			else if (p2.equals(first))
				first = p1;
			
		}
		
	}
	
	
	public void sortByName() {
		
		Person actual = first;
		
		if (actual != null) {
			
			Person next = actual.getNext();
			
			while (next != null) {
				
				if (actual.compareTo(next) > 0) {
					swap(actual, next);
					next = actual.getNext();
				}
				else {
					actual = next;
					next = next.getNext();
				}	
			}	
		}	
	}

	@Override
	public int compare(Clan c1, Clan c2) {
		
		int ret = c1.getName().compareToIgnoreCase(c2.getName());
		
		return ret;
		
	}
	
}
