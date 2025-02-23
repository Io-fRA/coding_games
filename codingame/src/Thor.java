import java.util.Scanner;

public class Thor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt();
        int lightY = in.nextInt();
        int thorX = in.nextInt();
        int thorY = in.nextInt();

        // Game loop
        while (true) {
            in.nextInt(); // Read remaining turns (not used)

            StringBuilder direction = new StringBuilder();

            if (thorY < lightY) {
                thorY++;
                direction.append("S");
            } else if (thorY > lightY) {
                thorY--;
                direction.append("N");
            }

            if (thorX < lightX) {
                thorX++;
                direction.append("E");
            } else if (thorX > lightX) {
                thorX--;
                direction.append("W");
            }

            System.out.println(direction);
        }
    }
}
