// Create linked list and perform following operations (20)
// (i)Display its elements in reverse order.
// (ii) Insert new element as last node and display updated list.

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LabTest {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(40);
        head.next.next = new Node(60);
        head.next.next.next = new Node(50);
        System.out.print("Linked list elements:- ");
        printList(head);
        System.out.println();
        System.out.println("at last");
        head = addAtlast(head, 55);
        printList(head);
        System.out.println();
        System.out.print("reverse Linked list elements:- ");
        head = reverseList(head);
        printList(head);
    }

   private static void printList(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }

 private static Node addAtlast(Node head, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}