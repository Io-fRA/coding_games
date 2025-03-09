import java.util.*;
import java.util.Arrays;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // If the intervals array is empty or has only one interval, return the same intervals
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by the starting value of each interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastMerged = merged.get(merged.size() - 1);

            // If the current interval overlaps with the last merged interval
            if (current[0] <= lastMerged[1]) {
                // Merge the intervals by updating the end of the last merged interval
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // Otherwise, just add the current interval
                merged.add(current);
            }
        }

        // Convert the List back to a 2D array and return the result
        return merged.toArray(new int[merged.size()][]);
    }

    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged intervals:");
        int[][] mergedIntervals = merge(intervals);
        printIntervals(mergedIntervals);
    }
}
