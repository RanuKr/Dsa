
public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int ans = solution(arr, k);
        System.out.println(ans);
    }

    private static int solution(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr[arr.length - k];
    }
}
