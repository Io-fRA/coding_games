package tutorial.math;

public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }

    public static boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false; // Negative numbers and zero can't be powers of 3
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1; // If n is reduced to 1, it is a power of 3
    }
}
