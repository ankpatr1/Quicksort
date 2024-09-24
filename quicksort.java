/**
 * 
 * Quicksort Implementation with Hoare Partitioning
 * Written by Ankita Patra 
 * 
 */

import java.util.*;

public class quicksort {
    /**
     * Main QuickSort method that sorts the array using the Quicksort algorithm.
     * 
     * 
     * @param arr    The array to be sorted.
     * @param low    The starting index of the range to be sorted.
     * @param high   The ending index of the range to be sorted.
     */

    // Main QuickSort method (recursive)
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Perform Hoare partitioning and get the pivot index
            int pivotIndex = hoarePartition(arr, low, high);
            // Recursively sort the two halves (elements before and after the pivot)
            quicksort(arr, low, pivotIndex);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Hoare partition scheme for the Quicksort Algo
     * 
     * 
     * @param arr       The array to be partitioned.
     * @param low       The starting index of the range to be partitioned.
     * @param high      The ending index of the range to be partitioned.
     * @return          The final index of the pivot element after partitioning.
     */
    public static int hoarePartition(int[] arr, int low, int high) {
        // Select/choose a random pivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];
        // Swap/Move the pivot with the low element
        swap(arr, low, pivotIndex);

        int left = low - 1;
        int right = high + 1;

        while (true) {
            // Move left index to the right until we find an element greater than the pivot
            left++;
            while (arr[left] < pivot) {
                left++;
            }

            // Move right index to the left until we find an element smaller than the pivot
            right--;
            while (arr[right] > pivot) {
                right--;
            }

            // If the indices cross, return the right index
            if (left >= right) {
                return right;
            }

            // Swap elements at the left and right indices
            swap(arr, left, right);
        }
    }

    /**
     * Helper method to swap two elements in the array.
     * @param arr   The array where elements will be swapped.
     * @param i     The index of the first element.
     * @param j     The index of the Second element.
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * Prints the array elements in a vertical format.
     * 
     * @param arr       The array to be printed
     * @param start     The starting index of the range to be printed.
     * @param end       The ending index of the range to be printed (exclusive).
     */
    
    public static void printNumbersVertically(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Main method to handle i/p, o/p, and sorting.
     * @param args  Command-line argument for specifying the sorting range.
     */
    public static void main(String[] args) {
        // Read i/p from stdin (read all i/p numbers from standard i/p)
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = new ArrayList<>();

        // Collect all i/p numbers
        while (scanner.hasNextInt()) {
            numbersList.add(scanner.nextInt());
        }

        // Convert List to array for sorting
        int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();

        // Check the number and Handle command-line arguments
        if (args.length == 0) {
            // No arguments provided, sort the entire array
            quicksort(numbers, 0, numbers.length - 1);
            
            //"we can use this as well for making code more user friendly"
            //System.out.println("Total numbers: " + numbers.length); 
            printNumbersVertically(numbers, 0, numbers.length); // Print vertically

        } else if (args.length == 2) {
            // Two arguments provided, sort the numbers in the range [a, b)
            try {
                // Convert the arguments to integers and adjust for 1-based indexing
                int a = Integer.parseInt(args[0]) - 1; // inclusive
                int b = Integer.parseInt(args[1]) - 1; // exclusive

                // Validate that the range is within bounds
                if (a < 0 || b > numbers.length || a >= b) {
                    throw new IllegalArgumentException("Invalid range");
                }

                // Sort only the specified range
                quicksort(numbers, a, b - 1);

                // Print the sorted subrange vertically
                System.out.println("Total numbers in range [" + (a + 1) + ", " + b + "]: " + (b - a));
                printNumbersVertically(numbers, a, b); // Print vertically sorted subrange 

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Invalid number of arguments. Provide either zero or two arguments.");
        }

        // Close the scanner to release resources 
        scanner.close();
    }
}
