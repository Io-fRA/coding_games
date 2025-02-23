import java.util.Scanner;

public class EncodingZeros {

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


 /*   public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[] MESSAGE = in.nextLine().toCharArray();

        boolean pbit = (MESSAGE[0] & 0x40) != 0;
        System.out.print(pbit ? "0 " : "00 ");

        for (char B : MESSAGE)
        {
            for (char bm = 0x40; bm != 0; bm >>= 1)
            {
                boolean bit = (B & bm) != 0;
                System.out.print((bit == pbit) ? "0"
                        : bit ? " 0 0"
                        : " 00 0");
                pbit = bit;
            }
        }
    }*/





    static String encodingToBinary(String inStr) {
        String binStr = "";
        char[] inChar = inStr.toCharArray();
        for (char c : inChar) {
            // jedes Zeichen in 8-stelligen Binärsting umwandeln
            String tmpStr = Integer.toBinaryString(c + 128);
            binStr += tmpStr.substring(1);
        }
        return binStr;
    }

    public static void main2(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        String answer = (" " + encodingToBinary(MESSAGE)).replace("01", "0 1").replace("10", "1 0").replace(" 1", " 1 1").replace(" 0", " 00 0").replace("1", "0").trim();

        System.out.println(answer);
    }






    static class Solution {

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            String MESSAGE = in.nextLine();
            System.err.println(MESSAGE);

            String completeBinaryString = "";
            String binaryString = "";
            for (int i = 0; i < MESSAGE.length(); i++) {
                System.err.println(MESSAGE.charAt(i));
                int decimalValue = MESSAGE.charAt(i);
                if (decimalValue <= 64) {
                    binaryString = binaryString + "0";
                }
                binaryString += Integer.toBinaryString(decimalValue);
                System.err.println(decimalValue);
            }

            System.err.println(binaryString);
            completeBinaryString = encodeToZeros(binaryString);
            System.out.println(completeBinaryString);
        }

        private static String encodeToZeros(String binaryString) {
            StringBuilder listOfZeros = new StringBuilder();
            // parse String i
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '0') {
                    int numberOfZeros = countSameFollowingValue(binaryString, i, '0');
                    System.err.println(numberOfZeros);
                    listOfZeros.append(" 00 ");
                    listOfZeros.append("0".repeat(Math.max(0, numberOfZeros)));
                    i += numberOfZeros - 1;
                } else {
                    int numberOfZeros = countSameFollowingValue(binaryString, i, '1');
                    System.err.println(numberOfZeros);
                    listOfZeros.append(" 0 ");
                    for (int j = 0; j < numberOfZeros; j++) {
                        listOfZeros.append("0");
                    }
                    i += numberOfZeros - 1;
                }
            }
            return listOfZeros.deleteCharAt(0).toString();
        }

        private static int countSameFollowingValue(String toParse, int index, char toCompare) {
            int numberOfFollowingSameValue = 0;
            while (index < toParse.length() && toParse.charAt(index) == toCompare) {
                index++;
                numberOfFollowingSameValue += 1;
            }
            return numberOfFollowingSameValue;
        }
    }
}
