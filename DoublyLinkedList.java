/*
 * 			AUTHOR: Todd Twiggs
 * 			DATE:   September 26, 2015
 */

import javax.swing.JOptionPane;

public class DoublyLinkedList {

	protected Person front, end;
	public int listSize;

	// Constructor for a linked list
	public DoublyLinkedList(){
		front = null;
		end = null;
		listSize = 0;
	}
	
	// Check to see if the list is empty
	boolean isEmpty(){
		return (front == null);
	}
	
	// Get the size of the list
	int getSize(){
		return listSize;
	}
	
	// Insert a Person at the front of the list
	void insertFront(String name){
		Person newPerson = new Person(name, null, null);
		
		if (front == null){
			front = newPerson;
			end = front;
		}
		else {
			front.setPrev(newPerson);
			newPerson.setNext(front);
			front = newPerson;
		}
		
		listSize++;
	} // End of insertFront
	
	// Insert a Person at the end of the list
	void insertEnd(String name){
		Person newPerson = new Person(name, null, null);
		
		if (front == null){
			front = newPerson;
			end = front;
		}
		else {
			end.setNext(newPerson);
			newPerson.setPrev(end);
			end = newPerson;
		}
		
		listSize++;
	} // End of insertEnd
	
	// Insert a Person at a given position
	void insertAtPosition(String name, int position){
		Person newPerson = new Person(name, null, null);
		
		if (position == 1){
			insertFront(name);
		}
		
		Person current = front;
		
		for (int i = 2; i <= listSize; i++){
			if (i == position){
				newPerson.setNext(current.getNext());
				current.getNext().setPrev(newPerson);
				current.setNext(newPerson);
				newPerson.setPrev(current);
			}
			else {
				current = current.getNext();
			}
		}
		listSize++;
	} // End of insertAtPosition
	
	// Delete a Person from a given position
	void deleteFromPosition(int position){
		if (position == 1){
			if (listSize == 1){
				front = null;
				end = null;
				listSize = 0;
			}
			else {
				front = front.getNext();
				front.setPrev(null);
				listSize--;
			}
		}
		else if (position == listSize){
			end = end.getPrev();
			end.setNext(null);
			listSize--;
		}
		else {
			Person current = front.getNext();
			for (int i = 2; i <= listSize; i++){
				if (i == position){
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					listSize--;
				}
				else {
					current = current.getNext();
				}
			}
		}
	} // End of deleteFromPosition
	
	// Search the list for a name
	int searchName(String name){
		int position = 0;
		Person current = front;
		for (int i = 1; i <= listSize; i++){
			if (current.getName().equals(name)){
				return i;
			}
			else {
				current = current.getNext();
			}
		}
		return position;
	} // End of searchName
	
	// Search the list by Position
	void searchPosition(int position){
		Person current = front;
		for (int i = 1; i <= listSize; i++){
			if (i == position){
				JOptionPane.showMessageDialog(null, "Position " + position + " contains " + current.getName());
				break;
			}
			current = current.getNext();
		}
	}// End of searchPosition
	
	// Print the contents of the list
	void print(String message){
		String output = message;
		output += "The list contains: \n";
		Person current = front;
		for (int i = 1; i < listSize; i++){
			if (i == 11){
				output += "\n";
			}
			output += current.getName() + ", ";
			current = current.getNext();
		}
		output += "and " + current.getName();
		JOptionPane.showMessageDialog(null, output);
	} // End of printList

} // End of class LinkedList
