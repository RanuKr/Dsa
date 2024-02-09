
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 5, 4, 1 };

        System.out.println("Original Array: ");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }

        insertionSort(arr);

        System.out.println("Sorted Array: ");
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
