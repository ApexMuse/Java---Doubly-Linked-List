/*
 * 			AUTHOR: Todd Twiggs
 * 			DATE:   September 26, 2015
 * 
 * 			In this assignment, you are going to implement doubly-linked list (DLL) of object Person discussed 
 * 			in class (refer to the slides for the basic structure).
 * 
 * 			Your code should have all basics operation implemented, including insertion a node, delete a node, 
 * 			searching and printing by a specific key (such as last name).
 * 
 * 			You should first construct a DLL of at least 20 nodes, this is done by consecutive applications of 
 * 			operation InsertFront(). Then demonstrate other operations. All the demonstrations must be able to 
 * 			be observed during a single run (that is, you cannot restart your program in order to demonstrate a 
 * 			single operation).
 */

import javax.swing.JOptionPane;

public class Quiz2 {

	public static void main(String[] args) {
		
		String[] names = {"Adam", "Bob", "Charles", "David", "Earl", "Fred", "Gary", "Harry", "Ian", "Julie", 
						  "Kevin", "Lou", "Mike", "Ned", "Oscar", "Paul", "Randy", "Steve", "Todd", "Victor"};
		
		// Create the linked list
		DoublyLinkedList myDLL = new DoublyLinkedList();
		
		// Insert 20 Persons by consecutive applications of insertFront()
		for (int i = 19; i >= 0; i--){
			myDLL.insertFront(names[i]);
		}
		
		// Print the size of the list
		String message = "The size of the initial doubly-linked list is: " + myDLL.getSize() + "\n\n";
		myDLL.print(message);
		
		// Insert a name at the end of the list
		String name = JOptionPane.showInputDialog("Type a name to insert at the end of the list: ");
		myDLL.insertEnd(name);
		myDLL.print("AFTER INSERTION AT END OF LIST:\n\n");
		
		// Insert at name at a specified position
		name = JOptionPane.showInputDialog("Type a name to insert: ");
		String positionString = JOptionPane.showInputDialog("At what position do you want to insert " + name + "?");
		int position = Integer.parseInt(positionString);
		myDLL.insertAtPosition(name, position);
		myDLL.print("AFTER INSERTION AT POSITION " + position + ":\n\n");
		
		// Search for a name in the list
		name = JOptionPane.showInputDialog("Search for a name: ");
		position = myDLL.searchName(name);
		if (position == 0) {
			JOptionPane.showMessageDialog(null, "Sorry, " + name + " is not in the list.");
		}
		else {
			JOptionPane.showMessageDialog(null, name + " was found at position " + position);
		}
		
		// Delete a specified name from the list
		name = JOptionPane.showInputDialog("Delete a name: ");
		position = myDLL.searchName(name);
		if (position == 0) {
			JOptionPane.showMessageDialog(null, "Sorry, " + name + " is not in the list.");
		}
		else {
			myDLL.deleteFromPosition(position);
			myDLL.print("AFTER DELETION:\n\n");
		}
		
		// Print a person's name from a specific position
		positionString = JOptionPane.showInputDialog("Enter a list position (1-" + myDLL.getSize() + "): ");
		position = Integer.parseInt(positionString);
		myDLL.searchPosition(position);
		
	}
}
