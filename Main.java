public class Main {
    public static void main(String[] args) {
        // Create a Queue using an array
        QueueArray queue = new QueueArray(5);

        // Enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue: " + queue);

        // Dequeue
        int removedNumber = queue.dequeue();
        System.out.println("Removed Element: " + removedNumber);

        System.out.println("Updated Queue: " + queue);
    }
}

class QueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity; // Circular increment
        }

        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Placeholder for an empty queue
        }

        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity; // Circular increment
        }

        size--;
        return value;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        int i = front;
        do {
            result.append(queue[i]);
            if (i != rear) {
                result.append(", ");
            }
            i = (i + 1) % capacity;
        } while (i != (rear + 1) % capacity);

        result.append("]");
        return result.toString();
    }
}
