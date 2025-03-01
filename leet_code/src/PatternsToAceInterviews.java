import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PatternsToAceInterviews {

    // Here a the following fourteen patterns to ace interviews
    // Used data structures: LinkedList, Arrays, String

    public static void main(String[] args) {
        System.out.println(slidingWindow(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));

        System.out.println(Arrays.toString(twoPointers(new int[]{-23, -10, -2, 0, 1, 3, 17, 20})));

        System.out.println(Arrays.deepToString(threeSumEqualsToZero(new int[]{-23, -10, -2, 0, 1, 9, 17, 20})));
    }

    // Sliding window
    // asked to find the longest/shortest substring, subarray, or a desired value
    // • Maximum sum subarray of size ‘K’ (easy)
    // • Longest substring with ‘K’ distinct characters (medium)
    // • String anagrams (hard)
    static int slidingWindow(int[] t, int k){
        // int[] t = {1, 4, 2, 10, 23, 3, 1, 0, 20}
        // k = 4
        // To find the maximum sum of all subarrays of size K

        if (t.length <= k) return 0;

        int max = 0;

        // First window value
        for (int i = 0; i < k ; i++){
            max+=t[i];
        }

        int windowSum = max;
        for (int i = k; i < t.length; i++) {
            windowSum += t[i] - t[i - k];
            max = Math.max(max, windowSum);
        }

        return max;
    }


    // Two pointers
    // • Problems where you deal with sorted arrays (or Linked Lists)
    //      and need to find a set of elements that fulfill certain constraints
    // • The set of elements in the array is a pair, a triplet, or even a subarray

    // Squaring an array in a non-decreasing order
    static int[] twoPointers(int[] t){
        int len, end;
        len = end = t.length - 1;
        int st = 0;

        int[] sqArr = new int[t.length];

        for (int i = 0; i < t.length; i++){
            t[i]*=t[i];
        }

        while (st < end){
            if (t[st] > t[end]) {
                sqArr[len] = t[st++];
            } else {
                sqArr[len] = t[end--];
            }
            len--;
        }
        return sqArr;
    }

    static int[][] threeSumEqualsToZero (int [] t){
        if (t.length < 3) return new int[][]{}; // Return empty if less than 3 elements

        Arrays.sort(t); // Sort the array
        System.out.println(Arrays.toString(t));

        List<int[]> result = new ArrayList<>(); // Use ArrayList to store the solutions
        int j, k, cur;

        for (int i = 0; i < t.length - 2; i++) {
            j = i + 1;
            k = t.length - 1;

            while (j < k) {
                cur = t[i] + t[j] + t[k];
                System.out.println(cur);

                if (cur == 0) {
                    result.add(new int[]{t[i], t[j], t[k]}); // Store the triplet

                    // Move both pointers (j and k) even if they are duplicates, because we are not skipping them
                    j++;
                    k--;
                } else if (cur > 0) {
                    k--; // Decrease sum
                } else {
                    j++; // Increase sum
                }
            }
        }

        // Convert List<int[]> to int[][] and return
        return result.toArray(new int[result.size()][]);
    }



    // Fast and Slow pointers
    // often used for cycle detection in linked lists
    static boolean isPalindromeFastSlowPointers(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = head.next;
            fast = head.next.next;
        }
        fast = head;
        slow  = reversedLinkedList(slow);

        while (slow != null){
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reversedLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    static List<int[]> mergeOverlap(int[][] arr) {

        // Sort intervals based on start values
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            // If current interval overlaps with the last merged
            // interval, merge them
            if (curr[0] <= last[1])
                last[1] = Math.max(last[1], curr[1]);
            else
                res.add(new int[]{curr[0], curr[1]});
        }

        return res;
    }


    // Cyclic sort
    // move each element in the array to its correct position based on its value
    // So for each number, say x, such that 1 <= x <= n, is placed at the (x – 1)th index

    // find the first missing positive number
    static int missingNumber(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // if arr[i] is within the range [1, n] and arr[i]
            // is not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n
                    && arr[i] != arr[arr[i] - 1]) {

                // then swap arr[i] and arr[arr[i]-1] to
                // place arr[i] to its corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        // If any number is not at its corresponding index
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }

        // If all number from 1 to n are present then n+1
        // is smallest missing number
        return n + 1;
    }

    // Tree BFS Breadth First Search


}
