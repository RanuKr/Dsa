import java.util.*;

public class ArrayInsertion {
    public static void main(String[] args) {

        int[] originalArray = { 1, 3, 4, 5, 6, 5, 3, 3 };
        System.out.println("originalarray" + Arrays.toString(originalArray));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to insert");
        int numberToinsert = scanner.nextInt();

        System.out.println("Enter the insertion position(0-based index)");
        int insertPosition = scanner.nextInt();

        int newSize = originalArray.length;
        int[] newArray = new int[newSize];

        // Copy elements from the original array to the new array up to the insert
        // position
        for (int i = 0; i < insertPosition; i++) {
            newArray[i] = originalArray[i];
        }

        // Insert the new element
        newArray[insertPosition] = numberToinsert;

        // Copy the remaining elements from the original array to the new array
        for (int i = insertPosition + 1; i < newSize; i++) {
            newArray[i] = originalArray[i - 1];
        }

        // Print the updated array
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Element to Insert: " + numberToinsert);
        System.out.println("Insert Position: " + insertPosition);
        System.out.println("Updated Array: " + Arrays.toString(newArray));

        // Close the scanner
        scanner.close();
    }
}
