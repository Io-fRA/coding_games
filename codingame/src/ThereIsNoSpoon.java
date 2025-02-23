import java.util.Scanner;

public class ThereIsNoSpoon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        in.nextLine();

        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            grid[i] = in.nextLine().toCharArray();
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == '0') {
                    int[] right = findNextNode(grid, x + 1, y, true);
                    int[] bottom = findNextNode(grid, x, y + 1, false);
                    System.out.println(x + " " + y + " " +
                            right[0] + " " + right[1] + " " +
                            bottom[0] + " " + bottom[1]);
                }
            }
        }
    }

    private static int[] findNextNode(char[][] grid, int x, int y, boolean horizontal) {
        int width = grid[0].length;
        int height = grid.length;

        while ((horizontal ? x < width : y < height)) {
            if (grid[y][x] == '0') {
                return new int[]{x, y};
            }
            if (horizontal) x++; else y++;
        }
        return new int[]{-1, -1};
    }
}
