public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.


        int maxSum = Integer.MIN_VALUE; // set max to the smallest possible value to begin with
        int n = arr.length;


        for (int lower = 0; lower < n; lower++) { // lower bound of the potential sub-array
            int sum = 0;
            for (int upper = lower; upper < n; upper++) { // lower bound of the potential sub-array
                sum += arr[upper]; // utilize a running sum to avoid using a third for loop (which will create n^3 complexity, which is even more terrible)
                if (sum > maxSum) {
                    maxSum = sum;
                }
                /**
                 * There are a constant number (4) of primitive operations inside this loop.
                 * This nested loop design will eventually run n(n-1)/2 times, 
                 * which approximates to a O(n^2) complexity.
                */

            }
        }

        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */

    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) { // start w/ second element
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]); // choose the best of two choices. either start anew or add to existing subarray.  
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            /**
             * There are a constant number (7) of primitive operations within this loop.
             * There is only one for-loop.
             * Hence, Kadane's Algorithm runs in O(n) time.
             */
        }

        return maxSoFar;
    }
}