import java.util.*;

public class SixDegreesOfKevinBacon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String actorName = in.nextLine();
        int n = in.nextInt();
        in.nextLine();  // consume the newline
        Map<String, Actor> actorsMap = new HashMap<>();

        // Read the movie casts
        for (int i = 0; i < n; i++) {
            String[] movieCast = in.nextLine().split(": ")[1].split(", ");
            for (String actor : movieCast) {
                actorsMap.putIfAbsent(actor, new Actor(actor));
                Actor currentActor = actorsMap.get(actor);
                currentActor.addConnectedActors(movieCast);
            }
        }

        // Set up a priority queue to process the actors based on their degrees
        Actor kevinBacon = actorsMap.get("Kevin Bacon");
        PriorityQueue<Actor> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.deg));
        queue.add(kevinBacon);

        // Initialize Kevin Bacon's degree
        kevinBacon.deg = 0;

        // Process the graph using BFS-like approach to calculate degrees
        while (!queue.isEmpty()) {
            Actor curr = queue.poll();
            if (curr.name.equals(actorName)) {
                System.out.println(curr.deg);
                return;
            }
            for (String connectedActorName : curr.connectedActors) {
                Actor next = actorsMap.get(connectedActorName);
                if (curr.deg + 1 < next.deg) {
                    next.deg = curr.deg + 1;
                    queue.add(next);
                }
            }
        }
    }

    // Actor class to represent each actor and their connections
    private static class Actor {
        String name;
        int deg = Integer.MAX_VALUE; // set to MAX_VALUE initially
        Set<String> connectedActors = new HashSet<>();

        public Actor(String name) {
            this.name = name;
        }

        public void addConnectedActors(String[] movieCast) {
            for (String castMember : movieCast) {
                if (!castMember.equals(name)) {
                    connectedActors.add(castMember);
                }
            }
        }
    }
}
