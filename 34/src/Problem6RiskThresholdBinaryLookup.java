import java.util.*;

public class Problem6RiskThresholdBinaryLookup {

    public static void main(String[] args) {

        int[] risks = {50, 10, 100, 25};

        // Linear Search (unsorted)
        linearSearch(risks, 30);

        // Sort array for Binary Search
        Arrays.sort(risks);
        System.out.println("Sorted Risks: " + Arrays.toString(risks));

        // Binary Search operations
        binaryOperations(risks, 30);
    }

    // 🔹 Linear Search
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("Found: " + found);
        System.out.println("Comparisons: " + comparisons);
    }

    // 🔹 Binary Search + Floor + Ceiling + Insertion
    static void binaryOperations(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        int floor = -1;
        int ceiling = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            }
            else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            }
            else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        int insertionPoint = low;

        System.out.println("\nBinary Search:");
        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceiling);
        System.out.println("Insertion Position: " + insertionPoint);
        System.out.println("Comparisons: " + comparisons);
    }
}