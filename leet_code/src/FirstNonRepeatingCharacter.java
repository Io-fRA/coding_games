import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character in a string
    public static char firstUniqChar(String s) {
        // HashMap to store character counts
        HashMap<Character, Integer> charCount = new HashMap<>();

        // First pass: Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Second pass: Find the first character with frequency 1
        for (char c : s.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        // If no non-repeating character is found, return a special value
        return '\0';  // Return null character if no unique character exists
    }

    public static void main(String[] args) {
        // Test the function with a sample string
        String s = "loveleetcode";
        char result = firstUniqChar(s);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
