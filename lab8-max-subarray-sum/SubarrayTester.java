import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Generate a random array and time both algorithms.

            int[] randomArray = generateRandomArrayWithNegatives(n);

            // first examine brute force.
            long startTime = System.nanoTime();
            int sum = MaxSubarraySolver.bruteForceMaxSum(randomArray);
            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            System.out.println("\t Brute Force Method --> " + (elapsed / 1000000) + " ms");

            // next examine brute force.
             startTime = System.nanoTime();
            sum = MaxSubarraySolver.kadanesAlgorithmMaxSum(randomArray);
            endTime = System.nanoTime();
            elapsed = endTime - startTime;
            System.out.println("\t Kadane's Algorithm Method --> " + (elapsed / 1000000) + " ms");


        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response

        int[] arr = new int[size];
        double min = Integer.MIN_VALUE;
        double max = Integer.MAX_VALUE;
        double range = max - min + 1;

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * range + min);

        }
        
        return arr;
    }
}