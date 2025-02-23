import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SotckMarketLosses {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberValues = in.nextInt();

        int[] tab = new int[numberValues];

        for (int i = 0; i < numberValues; i++) {
            tab[i] = in.nextInt();
        }

        int actualBiggest = tab[0];
        int actualSmaller = tab[0];

        int suitorBiggest = actualBiggest;

        for (int i = 0; i < numberValues; i++) {
            int v = tab[i];
            if (v > suitorBiggest) {
                suitorBiggest = v;
            } else if ((actualSmaller - actualBiggest) > (v - suitorBiggest)) {
                actualSmaller = v;
                actualBiggest = suitorBiggest;
            }
        }

        System.out.println(actualSmaller - actualBiggest);
    }
}
