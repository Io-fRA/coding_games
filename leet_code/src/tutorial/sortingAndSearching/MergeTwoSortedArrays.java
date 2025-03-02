package tutorial.sortingAndSearching;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 4, 5, 0, 0, 0}, 3, new int[]{6, 9, 16}, 3)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer for nums1
        int p2 = n - 1; // Pointer for nums2
        int p = m + n - 1; // Pointer for placing elements

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        return nums1;
    }
}
