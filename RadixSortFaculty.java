import java.util.Arrays;

class Faculty {
    String faculty_name;
    int faculty_ID;
    int subject_codes;
    String class_names;

    public Faculty(String faculty_name, int faculty_ID, int subject_codes, String class_names) {
        this.faculty_name = faculty_name;
        this.faculty_ID = faculty_ID;
        this.subject_codes = subject_codes;
        this.class_names = class_names;
    }
}

public class RadixSortFaculty {

    public static int getMaxID(Faculty[] arr) {
        int maxID = arr[0].faculty_ID;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].faculty_ID > maxID) {
                maxID = arr[i].faculty_ID;
            }
        }
        return maxID;
    }

    public static void countSort(Faculty[] arr, int exp, int swapCount) {
        int n = arr.length;
        Faculty[] output = new Faculty[n];
        int k = 10; 

        int[] count = new int[k];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int index = (arr[i].faculty_ID / exp) % k;
            count[index]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i].faculty_ID / exp) % k;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            swapCount++;
        }
    }

    public static void radixSort(Faculty[] arr) {
        int maxID = getMaxID(arr);
        int swapCount = 0;

        for (int exp = 1; maxID / exp > 0; exp *= 10) {
            countSort(arr, exp, swapCount);
        }

        System.out.println("Total number of swaps performed: " + swapCount);
    }

    public static void main(String[] args) {
        Faculty[] facultyArray = new Faculty[]{
            new Faculty("Faculty A", 354, 101, "Class X"),
            new Faculty("Faculty B", 223, 102, "Class Y"),
            new Faculty("Faculty C", 789, 103, "Class Z"),
           
        };

        radixSort(facultyArray);

        System.out.println("Sorted Faculty based on faculty_ID:");
        for (Faculty faculty : facultyArray) {
            System.out.println("Name: " + faculty.faculty_name + " ID: " + faculty.faculty_ID +
                    " Subject Codes: " + faculty.subject_codes + " Class Names: " + faculty.class_names);
        }
    }
}
