import java.util.Scanner;

public class ShadowsOfTheKnight {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int x = X0;
        int y = Y0;

        // Initialize the boundaries for the search area
        int xmin = 0, xmax = W;
        int ymin = 0, ymax = H;

        // Main game loop
        while (true) {
            String bombDir = in.next(); // direction of the bomb (U, UR, R, DR, D, DL, L, UL)

            // Update the boundaries based on the bomb direction
            if (bombDir.contains("U")) ymax = y;
            if (bombDir.contains("D")) ymin = y;
            if (bombDir.contains("R")) xmin = x;
            if (bombDir.contains("L")) xmax = x;

            // Find the new position of Batman (midpoint of the remaining area)
            x = (xmin + xmax) / 2;
            y = (ymin + ymax) / 2;

            // Output the new position Batman should jump to
            System.out.println(x + " " + y);
        }
    }
}
