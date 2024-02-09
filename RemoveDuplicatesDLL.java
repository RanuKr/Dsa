import java.util.HashSet;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class RemoveDuplicatesDLL {

    static Node head; // head of the doubly linked list

    // Function to remove duplicates from a doubly linked list
    static void removeDuplicates(Node head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> uniqueSet = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (uniqueSet.contains(current.data)) {
                // Remove the duplicate node
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            } else {
                // Add the current data to the set
                uniqueSet.add(current.data);
            }

            // Move to the next node
            current = current.next;
        }
    }

    // Function to print the doubly linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        removeDuplicates(head);

        System.out.println("Doubly Linked List after removing duplicates:");
        printList(head);
    }
}
