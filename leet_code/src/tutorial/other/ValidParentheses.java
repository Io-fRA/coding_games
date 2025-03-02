package tutorial.other;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        Map<Character, Character> closingMap = new HashMap<>();
        closingMap.put(')', '(');
        closingMap.put('}', '{');
        closingMap.put(']', '[');

        for (char c : s.toCharArray()) {
            if (!closingMap.containsKey(c)) {
                // opening parenthesis
                stack.push(c);
            } else {
                // closing parenthesis
                if (stack.isEmpty() || stack.pop() != closingMap.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
