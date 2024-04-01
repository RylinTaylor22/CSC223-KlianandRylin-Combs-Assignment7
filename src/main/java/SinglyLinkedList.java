/**
 * A class for creating and sorting a singly linked list
 * @author Klian Combs
 * @author Rylin Combs
 * 03/24/2024
 */
public class SinglyLinkedList {

    // instance variable of type 'Node' representing the starting point of the list
    private Node head;

    /**
    * A node class to represent individual elements in the list
    * @author Klian Combs
    * @author Rylin Combs
    * 03/24/2024
    */
    private static class Node {
        int data;
        Node next;

        // Constructor to initialize the data value 
        // and set its next reference to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add an element to the beginning of the list
    public void addFirst(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // Set its next reference to the head of the list
        newNode.next = head;
        // Update the head to point to the new node
        head = newNode;
    }

    // Method to add an element to the end of the list
    public void addLast(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set head to new node and return
        if (head == null) {
            head = newNode;
            return;
        }
      
        // Else, set current node to head
        Node current = head;
        // Traverse the list until the end node is found
        while (current.next != null) {
            current = current.next;
        }
      
        // Set the next reference of the last node to the new node
        current.next = newNode;
    }

    // Method to remove the first element from the list
    public void removeFirst() {
        // If the list is empty, do nothing
        if (head == null) {
            return;
        }
      
        // Else update head to next node essentially removing first node
        head = head.next;
    }

    // Method to remove the last element from the list
    public void removeLast() {
        // If the list empty or has only one element, set head to null 
        // Essentially emptying the list
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        // Else, update current node to head
        Node current = head;
        // Traverse the list until the second to last node 
        while (current.next.next != null) {
            current = current.next;
        }

        // Set its next pointer to null, removing last element
        current.next = null;
    }

    // Method to display the elements of the list
    public void displayList() {
        Node current = head;
        // Starting at the head, traverse the list until the end
        while (current != null) {
            // Print the data of each node while traversing
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to sort the list in ascending order using bubble sort
    public void bubbleSort() {
      // Start with the first node of the list
      Node current = head;
      // Outer loop to traverse the list
      while (current != null) {
        // Inner loop to compare current node with subsequent nodes
        Node runner = current.next;
        while (runner != null) {
          // Compare data of current node with data of subsequent node
          if (current.data > runner.data) {
            // Swap data if current node's data is greater than 
            // subsequent node's data
            int temp = current.data;
                  current.data = runner.data;
                  runner.data = temp;
              }
              // Move to the next node in the inner loop
              runner = runner.next;
          }
          // Move to the next node in the outer loop
          current = current.next;
      }
  }

    // Main method for demonstration
    public static void main(String[] args) {
      
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(3);
        list.addLast(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(4);
        list.addFirst(6);
        list.removeFirst();
        list.removeLast();

        System.out.println("Original list:");
        list.displayList();

        list.bubbleSort();

        System.out.println("Sorted list:");
        list.displayList();
    }
}