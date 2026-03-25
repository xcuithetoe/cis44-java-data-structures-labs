import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Call your test methods for Average, Best, and Worst cases.

            // first up: worst case scenario (reverse sorted array)


            // Time with selection sort on reverse array;

            System.out.println("\t WORST CASE (reversed sorted) SCENARIO");

            int[] reversedArray = generateReverseSortedArray(n);

            int[] reversedArray1 = reversedArray.clone();// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            long startTime = System.nanoTime();
            
            SortingAlgorithms.selectionSort(reversedArray1);
            long endTime = System.nanoTime();
            
            long elapsed = endTime - startTime;
            System.out.println("\t --> SELECTION sort: " + (elapsed / 1000000) + " ms");

            // Time with insertion sort on reversed sorted;
            reversedArray1 = reversedArray.clone();// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(reversedArray1);// make a copy so that the first algorithms doesn't already sort the array before the next algorithm
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> INSERTION sort: " + (elapsed / 1000000) + " ms");

            // Time with merge sort on reversed array;
            reversedArray1 = reversedArray.clone();// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(reversedArray1);// make a copy so that the first algorithms doesn't already sort the array before the next algorithm
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> MERGE sort: " + (elapsed / 1000000) + " ms");

            // second up: average case scenario (randomly generated array);
            
            System.out.println("\n \t AVERAGE CASE (randomly generated) SCENARIO");


            int[] randomArray = generateRandomArray(n);
            int[] randomArray1 = randomArray.clone();// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            // Time with selection sort on random array;
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(randomArray1);// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> SELECTION sort: " + (elapsed / 1000000) + " ms");

            // Time with insertion sort on random array;
            
            randomArray1 = randomArray.clone();
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(randomArray1);
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> INSERTION sort: " + (elapsed / 1000000) + " ms");

            // Time with merge sort on random array;
            randomArray1 = randomArray.clone();
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(randomArray1);
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> MERGE sort: " + (elapsed / 1000000) + " ms");


            // FINALLY: best case scenario (sorted array);
            
            System.out.println("\n \t BEST CASE (randomly generated) SCENARIO");


            int[] sortedArray = generateSortedArray(n);
            int[] sortedArray1 = sortedArray.clone();// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            // Time with selection sort on random array;
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(sortedArray1);// make a copy so that the first algorithms doesn't already sort the array before the next algorithm 
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> SELECTION sort: " + (elapsed / 1000000) + " ms");

            // Time with insertion sort on sorted array;
            
            randomArray1 = sortedArray.clone();
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(sortedArray1);
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> INSERTION sort: " + (elapsed / 1000000) + " ms");

            // Time with merge sort on sorted array;
            randomArray1 = sortedArray.clone();
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(sortedArray1);
            endTime = System.nanoTime();
            
            elapsed = endTime - startTime;
            System.out.println("\t --> MERGE sort: " + (elapsed / 1000000) + " ms");

        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        int[] randomArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt();
        }
        return randomArray;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i;
        }
        return sortedArray;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response
        int[] reverseSortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            reverseSortedArray[i] = size - i;
        }      
        return reverseSortedArray;
    }
}