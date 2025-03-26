public class FibonacciComparison {

    // Recursive Fibonacci (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // Change N to test different values

        // Measure Recursive Fibonacci Time
        long startRecursive = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + ") = " + resultRecursive +
                " | Time: " + (endRecursive - startRecursive) / 1_000_000.0 + " ms");

        // Measure Iterative Fibonacci Time
        long startIterative = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + ") = " + resultIterative +
                " | Time: " + (endIterative - startIterative) / 1_000_000.0 + " ms");
    }
}
