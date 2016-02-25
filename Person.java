/*
 * 			AUTHOR: Todd Twiggs
 * 			DATE:   September 26, 2015
 * 
 * 			This is the Person class for Quiz 2
 */

public class Person {
	
	protected String name;
	protected Person prev, next;

	public Person() {
		name = "";
		prev = null;
		next = null;
	}
	
	public Person(String newName, Person p, Person n) {
		name = newName;
		prev = p;
		next = n;
	}
	
	void setName(String newName) {
		name = newName;
	}
	
	String getName(){
		return name;
	}
	
	void setPrev(Person p){
		prev = p;
	}
	
	Person getPrev(){
		return prev;
	}
	
	void setNext(Person n){
		next = n;
	}
	
	Person getNext() {
		return next;
	}

}
