class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        // Base case: empty list or a single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive case: reverse the rest of the list
        ListNode reversedRest = reverseList(head.next);

        // Adjust the pointers to reverse the current node
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed list
        return reversedRest;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
