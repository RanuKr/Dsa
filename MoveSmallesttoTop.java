import java.util.Stack;

public class MoveSmallesttoTop {
    public static void moveSmallestToTop(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.err.println("Stack is empty!");
            return;
        }

        int smallest = stack.peek();
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current < smallest) {
                smallest = current;
            }
            temp.push(current);
        }

        stack.push(smallest);

        while (!temp.isEmpty()) {
            int current = temp.pop();
            if (current != smallest) {
                stack.push(current);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(5);
        myStack.push(2);
        myStack.push(7);
        myStack.push(1);
        myStack.push(9);

        System.out.print("Original stack: ");
        for (Integer element : myStack) {
            System.out.print(element + " ");
        }
        System.out.println();

        moveSmallestToTop(myStack);

        System.out.print("Stack after moving smallest element to the top: ");
        for (Integer element : myStack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
