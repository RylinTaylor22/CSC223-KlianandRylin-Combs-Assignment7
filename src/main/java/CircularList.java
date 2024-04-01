/**
 * A class for creating and searching a circular linked list
 * @author Klian Combs
 * @author Rylin Combs
 * 03/24/2024
 */
public class CircularList {

private Node head;

    // Node class to represent individual elements in the list
    private static class Node {
        int data;
        Node next;

        // Constructor to create a new node with given data
        Node(int data) {
            this.data = data;
            this.next = null; // Initialize next pointer to null
        }
    }

    // Method to add an element to the list
    public void add(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        // If empty, set the new node as the head
        if (head == null) {
            head = newNode; 
            // Make it circular by pointing to itself
            head.next = head; 
        } else {
            // Start traversal from the head
            Node current = head; 
            // Traverse to the last node in the circular list
            while (current.next != head) {
                current = current.next;
            }
          
            // Insert the new node at the end of the list
            current.next = newNode;
            // Make it circular by pointing to the head
            newNode.next = head;
        }
    }

    // Method to remove an element from the list
    public void remove(int data) {
        // If list is empty, nothing to remove
        if (head == null) {
            return;
        }
      
        // Check if the head node contains the data to be removed
        if (head.data == data) {
            // If head is the only node in the list, set it to null
            if (head.next == head) {
                head = null;
                return;
            }
          
            // Find the last node and update its next reference
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
          
            lastNode.next = head.next;
            // Move head to the next node
            head = head.next; 
            return;
        }
      
        // Traverse the list to find the node to be removed
        Node current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Method to display the elements of the list
    public void displayList() {
        // Print message if list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Start traversal from the head
        Node current = head; 
        // Traverse the circular list starting from the head
        do {
            // Print current node's data
            System.out.print(current.data + " "); 
            // Move to the next node
            current = current.next; 
          // Continue until back to the head
        } while (current != head); 
        System.out.println();
    }

    // Method to search for an item in the list
    public boolean search(int data) {
        // List is empty, item not found
        if (head == null) {
            return false;
        }
      
        // Start traversal from the head
        Node current = head; 
        // Traverse the circular list to find the item
        do {
            if (current.data == data) {
                return true; // Item found
            }

            // Move to the next node
            current = current.next; 
          // Continue until back to the head
        } while (current != head);
        return false; // Item not found
    }

  // Main method for demonstration
  public static void main(String[] args) {
      CircularList list = new CircularList();

      list.add(10);
      list.add(20);
      list.add(30);
      list.add(40);

      System.out.println("Original list:");
      list.displayList();

      int searchItem = 30;
      System.out.println("Searching for " + searchItem + ": " + list.search(searchItem));

      int removeItem = 20;
      list.remove(removeItem);
      System.out.println("List after removing " + removeItem + ":");
      list.displayList();
  }
}