import java.util.*;

public class AsciiArt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();

        // The alphabet we have to work with (this produces more intuitive code than subtracting "A" ascii index)
        String alphabet = "abcdefghijklmnopqrstuvwxyz?";

        // For each line of the display terminal
        for (int line = 0; line < H; line++) {
            String ROW = in.nextLine();
            // Then for each char of the given message (T)
            for (int i = 0; i < T.length(); i++) {
                // Index of the letter to display in our alphabet
                int index = alphabet.indexOf(T.substring(i, i + 1).toLowerCase());
                // If not found then we use the last letter which is '?'
                if (index == -1) index = alphabet.length() - 1;
                // We print the chars representing this letter
                System.out.print(ROW.substring(index * L, index * L + L));
            }
        }
    }

    static void OtherSolution() {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); // Width of each character's representation
        int H = in.nextInt(); // Height of each character's representation
        in.nextLine(); // Consume the newline character after the integers

        String T = in.nextLine().toUpperCase(); // Message to display, converted to uppercase

        // Create a map for fast character lookup, mapping each character to its index
        Map<Character, Integer> alphabetMap = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetMap.put(alphabet.charAt(i), i);
        }

        // List to store all rows (art representation of each character)
        List<String> artRows = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            artRows.add(in.nextLine());
        }

        // StringBuilder to accumulate the output (faster than printing each character individually)
        StringBuilder result = new StringBuilder();

        // Loop through each row of the output (height H)
        for (int i = 0; i < H; i++) {
            // Loop through each character in the message
            for (char c : T.toCharArray()) {
                // Get the index of the character in the alphabet (use '?' for unknown characters)
                int charIndex = alphabetMap.getOrDefault(c, alphabetMap.get('?'));

                // Extract the part of the row corresponding to the character
                result.append(artRows.get(i), charIndex * L, charIndex * L + L);
            }
            result.append("\n");
        }

        // Output the result
        System.out.print(result);
    }
}
