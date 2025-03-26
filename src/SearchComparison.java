import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes
        Random rand = new Random();

        for (int N : sizes) {
            int[] data = new int[N];

            // Fill the array with random values
            for (int i = 0; i < N; i++) {
                data[i] = rand.nextInt(N * 10); // Keeping range large for uniqueness
            }
            int target = data[rand.nextInt(N)]; // Random target from array

            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            // Sort before Binary Search
            Arrays.sort(data); // O(N log N)

            // Binary Search
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            // Print results
            System.out.println("Dataset Size: " + N);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time (after sorting): " + binaryTime / 1_000_000.0 + " ms");
            System.out.println("-------------------------------------");
        }
    }
}
