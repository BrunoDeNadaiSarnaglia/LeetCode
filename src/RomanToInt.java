import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Bruno on 7/17/2016.
 */
public class RomanToInt {

    HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};

    Comparator<Character> comparator = new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            return map.get(o1) - map.get(o2);
        }
    };

    public int romanToInt(String s) {
        if(s == null || s.length() == 0)    return 0;
        int sum = 0;
        int proposedSum = map.get(s.charAt(0));
        char currentVal = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if(comparator.compare(currentVal, s.charAt(i)) > 0){
                sum += proposedSum;
                currentVal = s.charAt(i);
                proposedSum = map.get(currentVal);
            } else if(comparator.compare(currentVal, s.charAt(i)) == 0){
                proposedSum += map.get(s.charAt(i));
            } else if(comparator.compare(currentVal, s.charAt(i)) < 0){
                sum -= proposedSum;
                currentVal = s.charAt(i);
                proposedSum = map.get(currentVal);
            }
        }
        sum += proposedSum;
        return sum;
    }
}
