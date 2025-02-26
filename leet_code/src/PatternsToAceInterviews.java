import java.util.ArrayList;
import java.util.Arrays;
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
}
