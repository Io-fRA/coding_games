package tutorial.other;

public class NumberOfOneBits {

    public static int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (char c: s.toCharArray()){
            if (c == '1') count++;
        }
        return count;
    }
}
