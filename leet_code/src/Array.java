public class Array {

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3};
        System.out.println(removeDuplicatesFromSortedArray(nums));
    }

    static int removeDuplicatesFromSortedArray(int[] nums){
        int posToReplace = 0;
        int index = 0;
        while (index < nums.length){
            if (nums[index] != nums[posToReplace]){
                posToReplace++;
                nums[posToReplace] = nums[index];
            }
            index ++;
        }
        return ++posToReplace;
    }

    static int maxProfit (int[] prices){
        int i = 0;
        int size = prices.length;
        int lo = prices[0];
        int hi = prices[0];
        int profit = 0;
        while (i < size - 1){
            // look to buy
            while (prices[i] >= prices[i+1]){
                i++;
            }
            lo = prices[i];
            // look to sell
            while (prices[i] <= prices[i+1]){
                i++;
            }
            hi = prices[i];
            profit += hi - lo;
        }
        return profit;
    }

    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
