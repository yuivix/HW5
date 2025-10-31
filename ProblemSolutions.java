/******************************************************************
 *
 *   Ryan Avalos / COMP 272 002
 *   External Source(s) Used: https://www.geeksforgeeks.org/java/priority-queue-in-java/
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        Set<Integer> set = new HashSet<>();

        // Adds set1 elements to hash
        for (int i = 0; i < list1.length; i++) {
            set.add(list1[i]);
        }
        // Returns false if set does't contain list2 elements 
        for (int j = 0; j < list2.length; j++) {
            if (!set.contains(list2[j])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
            // Removes smallest element if size is higher than k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
     }
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < array1.length; i++) {
            pq.add(array1[i]);
        }
        for (int j = 0; j < array2.length; j++) {
            pq.add(array2[j]);
        }
        // Set new array length
        int[] sortArray = new int[array1.length + array2.length];
        // Polls elements from minHeap in order
        for (int k = 0; k < sortArray.length; k++) {
            sortArray[k] = pq.poll();
        }
        return sortArray;
    }

}
