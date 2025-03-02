package tutorial.math;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int count = 0;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            char c1 = s.charAt(i);
            char c2 = ' ';
            if (i-1 >= 0){
                c2 = s.charAt(i-1);
            }
            int found1 = map.get(c1);
            int found2 = map.getOrDefault(c2, 0);
            if (found2 < found1){
                count += (found1 - found2);
                i--;
            } else {
                count += found1;
            }
        }
        return count;
    }

}
