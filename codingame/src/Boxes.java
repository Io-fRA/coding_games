public class Boxes {

    public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
        int sumOfBoxes = 0;
        int numOfStacks = boxes.length;

        // #1 Calculate the total number of boxes
        for (int box : boxes) {
            sumOfBoxes += box;
        }
        if (boxInClaw) {
            sumOfBoxes += 1;
        }

        // #2 Create a target array for distributing boxes evenly
        int[] target = new int[numOfStacks];
        while (sumOfBoxes > 0) {
            for (int i = 0; i < numOfStacks; i++) {
                target[i]++;
                sumOfBoxes--;
            }
        }

        // #3 Check if a box should be placed
        if (boxInClaw && boxes[clawPos] < target[clawPos]) {
            return "PLACE";
        }

        // #4 Check if a box should be picked
        if (!boxInClaw && boxes[clawPos] > target[clawPos]) {
            return "PICK";
        }

        // #5 Check if should go right
        for (int i = clawPos; i < numOfStacks; i++) {
            if (boxInClaw && boxes[i] < target[i]) {
                return "RIGHT";
            }
            if (!boxInClaw && boxes[i] > target[i]) {
                return "RIGHT";
            }
        }

        // #6 Check if should go left
        for (int i = clawPos; i >= 0; i--) {
            if (boxInClaw && boxes[i] < target[i]) {
                return "LEFT";
            }
            if (!boxInClaw && boxes[i] > target[i]) {
                return "LEFT";
            }
        }

        return "";
    }
}
