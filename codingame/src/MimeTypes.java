import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MimeTypes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.

            map.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            int fileExtensionPosition = FNAME.lastIndexOf('.');
            if (fileExtensionPosition == -1) {
                System.out.println("UNKNOWN");
            } else {
                String fileExt = FNAME.substring(fileExtensionPosition + 1).toLowerCase();
                System.out.println(map.getOrDefault(fileExt, "UNKNOWN"));
            }
        }


    }
}
