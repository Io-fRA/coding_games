import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargestSorting(int[] nums, int k) {
        // Sort the array in descending order
        Arrays.sort(nums);
        // Return the Kth largest element (index is k-1 because of 0-based indexing)
        return nums[nums.length - k];
    }


    // O(n*log(k))
    public static int findKthLargest(int[] nums, int k) {
        // Create a min-heap with a size of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add elements to the heap
        for (int num : nums) {
            minHeap.add(num);
            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the Kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));
    }
}
