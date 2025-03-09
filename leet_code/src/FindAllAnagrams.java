import java.util.*;
import java.util.Arrays;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Base cases
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Frequency count of characters in p
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Frequency count of characters in the current window in s
        int[] sCount = new int[26];

        // Initial window size is the length of p
        int windowSize = p.length();

        // Sliding window over s
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window's frequency count
            sCount[s.charAt(i) - 'a']++;

            // If the window exceeds the size of p, remove the leftmost character
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }

            // If the frequency counts match, it means we found an anagram
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("All anagram indices: " + anagramIndices);
    }
}
