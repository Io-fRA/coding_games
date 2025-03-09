public class BinarySearch {

    // Binary Search method
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // While the search range is valid
        while (low <= high) {
            // Find the middle index
            int mid = low + (high - low) / 2;  // To avoid overflow

            // Check if the target is at the middle
            if (arr[mid] == target) {
                return mid;  // Target found, return its index
            }

            // If target is greater than the middle element, search in the right half
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller than the middle element, search in the left half
            else {
                high = mid - 1;
            }
        }

        // Target is not in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Example usage: searching for number 7
        int target = 7;
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
