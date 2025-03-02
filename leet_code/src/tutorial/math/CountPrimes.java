package tutorial.math;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }



    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0; // No primes less than 2
        }

        // Create a boolean array "isPrime" and initialize all entries as true.
        // A value in isPrime[i] will be false if i is not a prime, true if i is a prime.
        boolean[] isPrime = new boolean[n];

        // Arrays.fill(isPrime, true)
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as false
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }



    // O(n * sqrt(n)) // Not efficient enough
    public static boolean isPrime(int num) {
        // Handle small numbers
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;  // 2 is prime
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;  // Exclude even numbers and numbers divisible by 3
        }

        // Check divisibility starting from 5, skipping even numbers and multiples of 3
        for (int i = 5; i * i <= num; i += 6) {  // Check numbers like 5, 11, 17, ...
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;  // Found a divisor, so the number is not prime
            }
        }

        return true;  // If no divisors were found, the number is prime
    }

}
