public class StringCompression {


    public static void main(String[] args) {
        //char[] chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars = new char[]{'a','a','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        System.out.println(chars);
    }

    // two pointers technique
    public static int compress(char[] chars) {

        // ["a","a","b","b","c","c","c"] --> ["a", "2", ...]

        if (chars == null || chars.length <= 1) return 0;

        int writeIndex = 0;
        int readIndex = 0;

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count consecutive occurrences of the current character
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character
            chars[writeIndex++] = currentChar;

            // Write the count if it's greater than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex;
    }
}
