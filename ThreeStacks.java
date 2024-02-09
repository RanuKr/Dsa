public class ThreeStacks {

    private int stackSize;
    private int[] array;
    private int[] top; // Array to store the top index of each stack

    // Constructor to initialize the three stacks
    public ThreeStacks(int stackSize) {
        this.stackSize = stackSize;
        this.array = new int[3 * stackSize];
        this.top = new int[]{0, stackSize, 2 * stackSize};
    }

    // Check if a specific stack is empty
    public boolean isEmpty(int stackNumber) {
        return top[stackNumber - 1] == (stackNumber - 1) * stackSize;
    }

    // Check if a specific stack is full
    public boolean isFull(int stackNumber) {
        return top[stackNumber - 1] == stackNumber * stackSize;
    }

    // Push an element onto a specific stack
    public void push(int stackNumber, int value) {
        if (isFull(stackNumber)) {
            System.out.println("Stack " + stackNumber + " is full. Cannot push " + value);
            return;
        }

        array[top[stackNumber - 1]++] = value;
    }

    // Pop an element from a specific stack
    public int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            System.out.println("Stack " + stackNumber + " is empty. Cannot pop.");
            return -1; // Return a sentinel value to indicate an empty stack
        }

        return array[--top[stackNumber - 1]];
    }

    public static void main(String[] args) {
        ThreeStacks threeStacks = new ThreeStacks(3);

        // Pushing elements onto the stacks
        threeStacks.push(1, 1);
        threeStacks.push(2, 2);
        threeStacks.push(3, 3);

        // Popping elements from the stacks
        System.out.println("Popped from Stack 1: " + threeStacks.pop(1));
        System.out.println("Popped from Stack 2: " + threeStacks.pop(2));
        System.out.println("Popped from Stack 3: " + threeStacks.pop(3));
    }
}
