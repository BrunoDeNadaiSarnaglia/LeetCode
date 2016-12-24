import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Bruno on 12/24/2016.
 */
public class FindRightInterval {



    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Interval, Integer> map = new TreeMap<Interval, Integer>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        int[] ceilingArray = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Interval, Integer> entry = map.ceilingEntry(new Interval(intervals[i].end, 0));
            ceilingArray[i] = (entry == null ? -1 : entry.getValue());
        }
        return ceilingArray;
    }

}
