import java.util.*;

public class Problem5AccountIDLookup {

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, "accB");
    }

    // 🔹 Linear Search
    static void linearSearch(String[] arr, String target) {
        int comparisons = 0;
        int firstIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                firstIndex = i;
                break;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First occurrence of " + target + ": " + firstIndex);
        System.out.println("Comparisons: " + comparisons);
    }

    // 🔹 Binary Search
    static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                index = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Count occurrences
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        System.out.println("\nBinary Search:");
        System.out.println("Index of " + target + ": " + index);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + comparisons);
    }
}