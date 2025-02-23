import java.util.Arrays;
import java.util.Scanner;

public class MinArrayDifference {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (N < 2) {
            System.out.println(0); // Edge case: If there's less than 2 elements, no meaningful difference
            return;
        }

        int[] powers = new int[N];
        for (int i = 0; i < N; i++) {
            powers[i] = in.nextInt();
        }

        Arrays.sort(powers);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            minDifference = Math.min(minDifference, powers[i] - powers[i - 1]); // Already sorted, no need for abs()
        }

        System.out.println(minDifference);
    }
}
