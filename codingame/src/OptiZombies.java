import java.util.*;
import java.util.function.Consumer;
import java.util.Arrays;


public class OptiZombies {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Runnable monTraitement = () -> System.out.println("traitement");
        Consumer<String> afficher = System.out::println;


        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int humanCount = in.nextInt();

            Map<Integer, Integer[]> humans = new HashMap<>();
            for (int i = 0; i < humanCount; i++) {
                int humanId = in.nextInt();
                int humanX = in.nextInt();
                int humanY = in.nextInt();
                Integer[] tab = new Integer[2];
                tab[0] = humanX;
                tab[1] = humanY;
                humans.put(humanId, tab);
            }
            int zombieCount = in.nextInt();
            Map<Integer, Integer[]> zombies = new HashMap<>();
            for (int i = 0; i < zombieCount; i++) {
                int zombieId = in.nextInt();
                int zombieX = in.nextInt();
                int zombieY = in.nextInt();
                Integer[] tab = new Integer[2];
                tab[0] = zombieX;
                tab[1] = zombieY;
                zombies.put(zombieId, tab);
                int zombieXNext = in.nextInt();
                int zombieYNext = in.nextInt();
            }

            // calculate human in danger that can be saved
            int danger = getHumanFurtherAwayFromZombies(humans, zombies);

            System.out.println(humans.get(danger)[0] + " " + humans.get(danger)[1]); // Your destination coordinates
        }
    }

    private static int getHumanFurtherAwayFromZombies(Map<Integer, Integer[]> humans,
                                                      Map<Integer, Integer[]> zombies)
    {
        int maxDistance = 0;
        Integer[] tabResult = new Integer[0];
        for (Integer[] tab : humans.values()) {
            int closest = distanceWithTheClosestZombie(tab[0], tab[1], zombies);
            //System.err.println("Current " + currentDist);
            //System.err.println("Max dist " + maxDistance);
            if (closest > maxDistance) {
                maxDistance = closest;
                tabResult = tab;
            }
        }

        for (Map.Entry<Integer, Integer[]> entry : humans.entrySet()) {
            if (Arrays.equals(entry.getValue(), tabResult)) {
                return entry.getKey();
            }
        }

        return 0;
    }


    private static int distanceWithTheClosestZombie(int x, int y, Map<Integer, Integer[]> zombies) {

        List<Integer> distanceWithZombie = new ArrayList<>();

        for (Integer[] tab : zombies.values()) {

            int currentDist = calculateDistance(x, y, tab[0], tab[1]);
            distanceWithZombie.add(currentDist);
        }
        return Collections.min(distanceWithZombie);
    }

    private static int calculateDistance(int x, int y, Integer xz, Integer yz) {
        return (int) (Math.sqrt((Math.abs(x*x-xz*xz) + (Math.abs(y*y-yz*yz)))));
    }
}
