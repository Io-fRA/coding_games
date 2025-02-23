import java.util.Scanner;

public class Defibrillators {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double userLon = Double.parseDouble(in.next().replace(',', '.'));
        double userLat = Double.parseDouble(in.next().replace(',', '.'));
        int defibCount = in.nextInt();
        in.nextLine(); // Consume leftover newline

        String closestDefib = "";
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < defibCount; i++) {
            String[] defibInfo = in.nextLine().replace(',', '.').split(";");
            double defibLon = Double.parseDouble(defibInfo[4]);
            double defibLat = Double.parseDouble(defibInfo[5]);
            double distance = calculateDistance(userLon, userLat, defibLon, defibLat);

            if (distance < minDistance) {
                minDistance = distance;
                closestDefib = defibInfo[1];
            }
        }

        System.out.println(closestDefib);
    }

    private static double calculateDistance(double lonA, double latA, double lonB, double latB) {
        double x = lonB - lonA * Math.cos((latA + latB) / 2);
        double y = latB - latA;
        return Math.sqrt(x * x + y * y) * 6371;
    }
}
