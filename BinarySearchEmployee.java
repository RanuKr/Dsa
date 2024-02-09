import java.util.Arrays;

public class BinarySearchEmployee {
    static class employee {
        int no;
        String name;
        int salary;

        employee(int no, String name, int salary) {
            this.no = no;
            this.name = name;
            this.salary = salary;
        }

    }

    public static void main(String[] args) {
        employee arr[] = new employee[5];
        arr[0] = new employee(4, "Manglam", 12000);
        arr[1] = new employee(2, "Simran", 8000);
        arr[2] = new employee(12, "Lucky", 63873);
        arr[3] = new employee(1, "Amit", 123000);
        arr[4] = new employee(7, "sweety", 15000);
        int k = 4;
        boolean ans = solution(arr, k);
        System.out.println(ans);

    }

    private static boolean solution(employee[] arr, int k) {
        Arrays.sort(arr, (a, b) -> a.no - b.no);
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].no == k) {
                return true;
            } else if (arr[mid].no < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
