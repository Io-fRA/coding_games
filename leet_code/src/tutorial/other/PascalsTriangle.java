package tutorial.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(6));
    }

    // Input: numRows = 5
    // Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l = new ArrayList<>();

        if (numRows == 0) return l;

        l.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            List<Integer> prev = l.get(i-1);

            level.add(1);
            for (int j = 1; j < i; j++) {
                level.add(prev.get(j) + prev.get(j-1));
            }
            level.add(1);
            l.add(level);
        }

        return l;
    }
}
