public class myStack {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void push(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void pop() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public static void main(String[] args) {
        myStack x = new myStack();
        x.push(0);
        x.push(1);
        x.push(2);
        x.push(4);
        x.push(5);
        x.print();
        x.pop();
        x.print();

    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }
}
