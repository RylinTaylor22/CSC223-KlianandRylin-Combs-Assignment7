/**
 * A class for creating and printing a doubly linked list
 * @author Klian Combs
 * @author Rylin Combs
 * 03/24/2024
 */
public class DoublyLinkedList {

    private Node head; // points to the first node
    private Node tail; // points to the last node
    private int size;  // stores the number of elements in the list

    /**
     * A node class to represent individual elements in the list
     * @author Klian Combs
     * @author Rylin Combs
     * 03/24/2024
     */
    private static class Node {
        int data;  // Node's data value
        Node prev; // Previous node reference
        Node next; // Next node reference

        // Constructor to initialize nodes
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Method to add an element to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        // If list is empty, update head pointer to new node 
        if (head == null) {
            head = newNode;
            tail = newNode;
          // After populating list, adjust prev and next pointers
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        // Increment the size of the list since a new node has been added
        size++;
    }

    // Method to add an element to the end of the list
    public void addLast(int data) {
      // Create a new node with the provided data
      Node newNode = new Node(data);

      // If the list is empty, set both head and tail to the new node
      if (tail == null) {
        head = newNode;
        tail = newNode;
      } else {
          // If the list is not empty, attach the new node to the end of the list
          // Set the previous pointer of the new node to point to the current tail
          newNode.prev = tail;
          // Set the next pointer of the current tail to point to the new node
          tail.next = newNode;
          // Update the tail pointer to point to the new node, 
          // which is now the last node
          tail = newNode;
      }
      // Increment the size of the list since a new node has been added
      size++;
  }


    // Method to remove the first element from the list
    public void removeFirst() {
      // Check if the list is empty
      if (head == null) {
        return; // List is empty, nothing to remove
      }

      // Check if there's only one node in the list
      if (head == tail) {
        // If there's only one node, remove it and set both head and tail to null
        head = null;
        tail = null;
      } else {
          // If there are more than one nodes, remove the first node
          // Move the head pointer to the next node
          head = head.next;
          // Set the previous pointer of the new head to null
          head.prev = null;
      }
      // Decrement the size of the list
      size--;
  }

    // Method to remove the last element from the list
    public void removeLast() {
      // Check if the list is empty
      if (tail == null) {
        return; // List is empty, nothing to remove
      }

      // Check if there's only one node in the list
      if (head == tail) {
        // If there's only one node, remove it and set both head and tail to null
        head = null;
        tail = null;
      } else {
          // If there are more than one nodes, remove the last node
          // Move the tail pointer to the previous node
          tail = tail.prev;
          // Set the next pointer of the new tail to null
          tail.next = null;
      }
      // Decrement the size of the list
      size--;
  }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to return the number of items in the list
    public int getLength() {
        return size;
    }

    // Method to display the elements of the list
    public void displayList() {
      // Start from the head of the list
      Node current = head;
      // Traverse the list and print each element's data
      while (current != null) {
        System.out.print(current.data + " ");
        current = current.next; // Move to the next node
      }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(3);
        list.addLast(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(4);

        System.out.println("Original list:");
        list.displayList();

        System.out.println("Is the list empty? " + list.isEmpty());
        System.out.println("Number of items in the list: " + list.getLength());

        list.removeFirst();
        list.removeLast();

        System.out.println("List after removing first and last elements:");
        list.displayList();
    }
}