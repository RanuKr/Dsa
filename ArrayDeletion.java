import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the original array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] originalArray = new int[n];
        System.out.print("Enter the elements of the array (space-separated): ");
        for (int i = 0; i < n; i++) {
            originalArray[i] = scanner.nextInt();
        }

        // Input the element to delete
        System.out.print("Enter the element to delete: ");
        int elementToDelete = scanner.nextInt();

        // Find the index of the element to delete
        int deleteIndex = -1;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == elementToDelete) {
                deleteIndex = i;
                break;
            }
        }

        // Check if the element was found
        if (deleteIndex != -1) {
            // Calculate the new array size
            int newSize = originalArray.length - 1;

            // Create a new array with the updated size
            int[] newArray = new int[newSize];

            // Copy elements from the original array to the new array before the deletion
            // point
            for (int i = 0; i < deleteIndex; i++) {
                newArray[i] = originalArray[i];
            }

            // Copy elements from the original array to the new array after the deletion
            // point
            for (int i = deleteIndex + 1; i < originalArray.length; i++) {
                newArray[i - 1] = originalArray[i];
            }

            // Print the updated array
            System.out.println("Original Array: " + Arrays.toString(originalArray));
            System.out.println("Element to Delete: " + elementToDelete);
            System.out.println("Updated Array: " + Arrays.toString(newArray));
        } else {
            System.out.println("Element not found in the array.");
        }

        // Close the scanner
        scanner.close();
    }
}
