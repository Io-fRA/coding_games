package tutorial.other;

public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    // 1     (0 0 0 1)
    // 4     (0 1 0 0)
    // XOR   (0 1 0 1)
    // XOR-1 (0 1 0 0)
    // &     (0 1 0 0)
    // XOR-1 (0 0 1 1)
    // &     (0 0 0 0)
    // Output 2
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // clears the less significant bit
            xor &= (xor - 1);
        }
        return distance;
    }
}
