public class StringConcatenationComparison {
    static final int N = 1_000_000; // Number of concatenations

    // Using String (O(N²))
    public static void testString() {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Creates a new object each time
        }
        long endTime = System.nanoTime();
        System.out.println("String Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // Using StringBuilder (O(N))
    public static void testStringBuilder() {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // Using StringBuffer (O(N))
    public static void testStringBuffer() {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        System.out.println("Operations Count: " + N);

        // Uncomment the testString() method for small values of N (e.g., 10,000)
        // testString();

        testStringBuilder();
        testStringBuffer();
    }
}
