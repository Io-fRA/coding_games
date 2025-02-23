import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringManipulations {

    public static void main(String[] args) {
        String s = "esgs";
        System.out.println(reverse(s));
    }
    public static String reverse(String input) {
        if (input == null) return null;
        StringBuilder reversed = new StringBuilder();
        // Loop from the end to the beginning
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void reverseStringInteger (int x){
        String s = String.valueOf(x);
        boolean isMinus = '-' == (s.charAt(0));
        if (isMinus){
            s = s.substring(1, s.length()-1);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        x = Integer.parseInt(sb.toString());
        if (isMinus){
            x = -x;
        }
    }

    public int atoi(String s) {
        int index = 0, total = 0, sign = 1;
        s = s.trim(); // Remove leading and trailing whitespace

        if (s.isEmpty()) return 0;

        // Handle sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index++) == '+' ? 1 : -1;
        }

        while (index < s.length()) {
            // converts a character digit to its corresponding integer value
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            // Check for overflow
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        // Check up to sqrt(n) is enough for efficiency
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void swappingTwoNumbersWithoutUsingAThrid() {
        int a = 10, b = 20;
        // Swap using arithmetic operators
        a = a + b; // a becomes 30
        b = a - b; // b becomes 10 (30 - 20)
        a = a - b; // a becomes 20 (30 - 10)
        System.out.println("a: " + a + ", b: " + b); // a: 20, b: 10
    }

    public static String getSimplifiedString(String input){
        // aaabb -> a3b2
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // Append the last character and its count
        result.append(input.charAt(input.length() - 1)).append(count);

        return result.toString();
    }

    public static boolean isEven(int length) {
        return length % 2 == 0;
    }

    public static String findFirstEvenString(String inputString) {
        String[] words = inputString.split(" ");
        String maxEvenString = "";

        for (String word : words) {
            if (isEven(word.length()) && word.length() > maxEvenString.length()) {
                maxEvenString = word;
            }
        }

        return maxEvenString;
    }

    public static char getFirstRepeatingCharacter(String inputString) {
        HashSet<Character> charset = new HashSet<>();

        for (char ch : inputString.toCharArray()) {
            if (!charset.add(ch)) { // If add() returns false, it's a duplicate
                return ch;
            }
        }
        return '\0'; // Return null character if no repetition
    }

    private static char findFirstNonRepeatingCharacter(char[] arr) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count occurrences while maintaining order
        for (char c : arr) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Return the first character with a count of 1
        return charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }
}
