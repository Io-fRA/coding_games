public class PowerOfTwo {

    // Function to determine if n is a power of two
    public static boolean isPowerOfTwo(int n) {
        // Check if the number is greater than 0 and if it satisfies the condition
        return n > 0 && (n & (n - 1)) == 0;
        // This works because:
        // For a power of two, the binary representation has exactly one 1 bit
        // Subtracting 1 from a power of two flips all the bits to the right of the only 1 bit.
        // When we perform a bitwise AND between n and n - 1,
        // the result will be 0 only if there is exactly one 1 bit in n
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPowerOfTwo(16)); // true, because 16 = 2^4
        System.out.println(isPowerOfTwo(18)); // false, because 18 is not a power of two
        System.out.println(isPowerOfTwo(1));  // true, because 1 = 2^0
        System.out.println(isPowerOfTwo(0));  // false, because 0 is not a power of two
        System.out.println(isPowerOfTwo(-8)); // false, because negative numbers can't be powers of two
    }
}
