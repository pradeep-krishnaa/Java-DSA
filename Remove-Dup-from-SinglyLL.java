import java.util.HashSet;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Remove duplicates using HashSet
    public void removeDuplicates() {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next; // Remove duplicate
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class Main{

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements (with duplicates)
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.printList();

        list.removeDuplicates();

        System.out.println("After Removing Duplicates:");
        list.printList();
    }
}
