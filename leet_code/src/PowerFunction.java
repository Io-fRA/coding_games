public class PowerFunction {

    // Function to compute x^n
    public static double myPow(double x, int n) {
        // Handle edge case: x^0 is always 1
        if (n == 0) {
            return 1;
        }

        // Handle negative exponents by using reciprocal
        if (n < 0) {
            x = 1 / x;
            n = -n;  // Make n positive
        }

        return power(x, n);
    }

    // Helper function to compute x^n using exponentiation by squaring
    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;

        System.out.println("Result of " + x + " raised to the power of " + n + " is: " + myPow(x, n));

        // Test with negative exponent
        System.out.println("Result of " + x + " raised to the power of -2 is: " + myPow(x, -2));
    }
}
