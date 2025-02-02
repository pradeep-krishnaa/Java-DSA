class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList
{
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

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position is out of bounds.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete the first occurrence of a node with given value
    public void deleteNode(int key) {
        if (head == null) return;

        // If the node to be deleted is the head
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next; // Bypass the node to be deleted
                return;
            }
            temp = temp.next;
        }
    }

    // Delete the node at the beginning
    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    // Delete the node at the end
    public void deleteAtEnd() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; // Remove the last node
    }

    // Print the list
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

        // Insert elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);

        System.out.println("Original List:");
        list.printList();

        // Delete elements
        list.deleteNode(20);
        System.out.println("After deleting 20:");
        list.printList();

        list.deleteAtBeginning();
        System.out.println("After deleting the first element:");
        list.printList();

        list.deleteAtEnd();
        System.out.println("After deleting the last element:");
        list.printList();
    }
}
