public class Knapsack {

    public static int knapsack(int maxWeight, int[] W, int[] V) {

        if (W == null || V == null || W.length != V.length || maxWeight < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        final int N = W.length;

        // Initialize a table where individual rows represent items
        // and columns represent the weight of the knapsack
        int[][] DP = new int[N + 1][maxWeight + 1];

        for (int i = 1; i <= N; i++) {

            // Get the value and weight of the item
            int w = W[i - 1], v = V[i - 1];

            for (int sz = 1; sz <= maxWeight; sz++) {

                // Consider not picking this element
                DP[i][sz] = DP[i - 1][sz];

                // Consider including the current element and
                // see if this would be more profitable
                if (sz >= w && DP[i - 1][sz - w] + v > DP[i][sz]) {
                    DP[i][sz] = DP[i - 1][sz - w] + v;
                }
            }
        }

        // Return the maximum profit
        return DP[N][maxWeight];
    }
}
