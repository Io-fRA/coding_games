import java.util.*;

public class Unary {

    // String to 0
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        System.err.println(message);

        // Convert message to a 7-bit binary string
        StringBuilder binaryString = new StringBuilder();
        for (char c : message.toCharArray()) {
            binaryString.append(String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0'));
        }

        System.err.println(binaryString); // Debugging output

        // Convert binary string to unary encoded format
        System.out.println(encodeToZeros(binaryString.toString()));
    }

    private static String encodeToZeros(String binaryString) {
        StringBuilder encoded = new StringBuilder();
        char prev = binaryString.charAt(0);
        encoded.append(prev == '0' ? "00 0" : "0 0");

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == prev) {
                encoded.append("0");
            } else {
                encoded.append(binaryString.charAt(i) == '0' ? " 00 0" : " 0 0");
            }
            prev = binaryString.charAt(i);
        }
        return encoded.toString();
    }
}
