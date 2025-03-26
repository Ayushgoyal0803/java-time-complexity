import java.io.*;

public class FileReadingComparison {
    static final String FILE_PATH = "src/largefile.txt"; // Change to actual file path

    // Using FileReader (Character Stream) - O(N)
    public static void testFileReader() throws IOException {
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(FILE_PATH)) {
            while (fr.read() != -1) {} // Reading character by character
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // Using InputStreamReader (Byte Stream) - O(N)
    public static void testInputStreamReader() throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH))) {
            while (isr.read() != -1) {} // Reading byte by byte and converting to character
        }
        long endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Reading File: " + FILE_PATH);
        testFileReader();
        testInputStreamReader();
    }
}
