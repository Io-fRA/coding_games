import java.util.List;

public class ClosestToZero {
    public double closestToZero(List<Double> ts) {
        double min = 5526.0;
        for (Double d: ts){
            if (Math.abs(d) < Math.abs(min) || (0 < d && -min == d)){
                min = d;
            }
        }
        return min;
    }
}
