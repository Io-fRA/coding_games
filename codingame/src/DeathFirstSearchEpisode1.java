import java.util.*;


public class DeathFirstSearchEpisode1 {

    static class Node {
        int id;
        List<Integer> neighbors;
        boolean isGateway;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
            this.isGateway = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        String[] inputs = scanner.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // the total number of nodes in the level, including the gateways
        int L = Integer.parseInt(inputs[1]); // the number of links
        int E = Integer.parseInt(inputs[2]); // the number of exit gateways

        // Create list of Nodes
        List<Node> listNode = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listNode.add(new Node(i));
        }

        // Read links and build the neighbors list
        for (int i = 0; i < L; i++) {
            String[] linkInputs = scanner.nextLine().split(" ");
            int N1 = Integer.parseInt(linkInputs[0]); // N1 and N2 define a link between these nodes
            int N2 = Integer.parseInt(linkInputs[1]);

            listNode.get(N1).neighbors.add(N2);
            listNode.get(N2).neighbors.add(N1);
        }

        // Read gateway nodes and set the 'isGateway' flag
        for (int i = 0; i < E; i++) {
            int EI = Integer.parseInt(scanner.nextLine()); // the index of a gateway node
            listNode.get(EI).isGateway = true;
        }

        // Game loop
        while (true) {
            // The index of the node on which the Bobnet agent is positioned this turn
            int SI = Integer.parseInt(scanner.nextLine());
            Node n = listNode.get(SI);
            Node priorityNode = null;

            // Check for priority neighbors that are gateways
            for (int voisinId : n.neighbors) {
                if (listNode.get(voisinId).isGateway) {
                    priorityNode = listNode.get(voisinId);
                    break;
                }
            }

            // Output the result
            if (priorityNode != null) {
                System.out.println(priorityNode.id + " " + SI);
            } else {
                System.out.println(n.neighbors.get(0) + " " + SI);
            }
        }
    }
}