public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize the queue
    public CircularQueue(int capacity) {
        queue = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == queue.length;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to insert (enqueue) a number into the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % queue.length; // Circular increment
        }

        queue[rear] = value;
        size++;
    }

    // Method to remove (dequeue) a number from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Placeholder for an empty queue
        }

        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length; // Circular increment
        }

        size--;
        return value;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        // Enqueue numbers into the queue
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        // Dequeue and print numbers
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
