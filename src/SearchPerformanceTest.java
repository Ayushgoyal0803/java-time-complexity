import java.util.*;

public class SearchPerformanceTest {

    static final int DATASET_SIZE = 1_000_000; // Change this to test different sizes
    static final int SEARCH_ELEMENT = DATASET_SIZE / 2; // Searching for a middle element

    public static void main(String[] args) {
        // Generate dataset
        int[] array = new int[DATASET_SIZE];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < DATASET_SIZE; i++) {
            array[i] = i; // Filling array
            hashSet.add(i); // Adding to HashSet
            treeSet.add(i); // Adding to TreeSet
        }

        // Measure Array Search Time (O(N))
        long startArray = System.nanoTime();
        boolean foundArray = linearSearch(array, SEARCH_ELEMENT);
        long endArray = System.nanoTime();
        System.out.println("Array Search: Found = " + foundArray +
                " | Time: " + (endArray - startArray) / 1_000_000.0 + " ms");

        // Measure HashSet Search Time (O(1))
        long startHashSet = System.nanoTime();
        boolean foundHashSet = hashSet.contains(SEARCH_ELEMENT);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search: Found = " + foundHashSet +
                " | Time: " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");

        // Measure TreeSet Search Time (O(log N))
        long startTreeSet = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(SEARCH_ELEMENT);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search: Found = " + foundTreeSet +
                " | Time: " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");
    }

    // Linear Search for Array (O(N))
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
