package tutorial.other;

public class ReverseBits {

    // Input: n = 00000010100101000001111010011100
    // Output:    (00111001011110000010100101000000)
    // the last bits of n are returned at the first places
    public int reverseBits(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
