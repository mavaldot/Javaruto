package model;

import java.util.Comparator;

public class Person implements Comparable<Person>, Comparator<Person> {

	private String name;
	private String personality;
	private String creationDate;
	private int power;
	private Technique tech;
	
	private Person prev;
	private Person next;
	
	public Person(String name, String personality, String creationDate, int power) {

		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Technique getTech() {
		return tech;
	}
	public void setTech(Technique tech) {
		this.tech = tech;
	}
	public Person getPrev() {
		return prev;
	}
	public void setPrev(Person prev) {
		this.prev = prev;
	}
	public Person getNext() {
		return next;
	}
	public void setNext(Person next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", personality=" + personality + ", creationDate=" + creationDate + ", power="
				+ power + "]";
	}

	@Override
	public int compare(Person p1, Person p2) {

		int ret = p1.getPower() - p2.getPower();
		return ret;
	}

	@Override
	public int compareTo(Person p) {
		
		int ret  = name.compareTo(p.getName());
		return ret;
	}
	
	
	
}