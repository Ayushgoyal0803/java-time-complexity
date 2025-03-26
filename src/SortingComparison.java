import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort (O(N²))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Break if already sorted
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes
        Random rand = new Random();

        for (int N : sizes) {
            int[] data = new int[N];
            for (int i = 0; i < N; i++) data[i] = rand.nextInt(N * 10); // Random values

            System.out.println("\nDataset Size: " + N);

            // Bubble Sort
            int[] bubbleData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            if (N <= 10000) { // Avoid running Bubble Sort for large datasets
                bubbleSort(bubbleData);
                System.out.println("Bubble Sort Time: " + (System.nanoTime() - startTime) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Merge Sort
            int[] mergeData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            System.out.println("Merge Sort Time: " + (System.nanoTime() - startTime) / 1_000_000.0 + " ms");

            // Quick Sort
            int[] quickData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            System.out.println("Quick Sort Time: " + (System.nanoTime() - startTime) / 1_000_000.0 + " ms");
        }
    }
}
