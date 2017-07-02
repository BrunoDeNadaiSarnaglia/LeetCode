import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarnaglia on 7/1/17.
 */
public class MaximumDistanceArrays {

    public static void main(String[] args) {
        MaximumDistanceArrays m = new MaximumDistanceArrays();
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1); l1.add(4);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0); l2.add(5);
        l.add(l1);
        l.add(l2);
        m.maxDistance(l);
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0) <= arrays.get(1).get(0) ? 0 : 1;
        int secMin = min == 0 ? 1 : 0;
        int max = arrays.get(0).get(arrays.get(0).size() - 1) >= arrays.get(1).get(arrays.get(1).size() - 1) ? 0 : 1;
        int secMax = max == 0 ? 1 : 0;
        for (int i = 2; i < arrays.size(); i++) {
            if(arrays.get(i).get(0) < arrays.get(min).get(0)) {
                secMin = min;
                min = i;
            } else if(arrays.get(i).get(0) < arrays.get(secMin).get(0)) {
                secMin = i;
            }
        }
        for (int i = 2; i < arrays.size(); i++) {
            if(arrays.get(i).get(arrays.get(i).size() - 1) > arrays.get(max).get(arrays.get(max).size() - 1)) {
                secMax = max;
                max = i;
            } else if(arrays.get(i).get(arrays.get(i).size() - 1) > arrays.get(secMax).get(arrays.get(secMax).size() - 1)) {
                secMax = i;
            }
        }
        System.out.println(min);
        System.out.println(secMin);
        System.out.println(max);
        System.out.println(secMax);
        if(max != min) {
            return arrays.get(max).get(arrays.get(max).size() - 1) - arrays.get(min).get(0);
        }
        return Math.max(
                arrays.get(max).get(arrays.get(max).size() - 1) - arrays.get(secMin).get(0),
                arrays.get(secMax).get(arrays.get(secMax).size() - 1) - arrays.get(min).get(0)
        );
    }

}
