
public class CharToInt {

    public static void main(String[] args) {
        String s = "gesg";
        for (char c : s.toUpperCase().toCharArray()){
            // ASCII Code for maj
            int value = c - 65;
        }
    }
}