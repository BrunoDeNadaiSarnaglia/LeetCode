import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)  return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int i = 0;
        int j = 0;
        int count = 1;
        while (j < intervals.length){
            if(intervals[j].start < intervals[i].end){
                j++;
            } else {
                i = j;
                count++;
            }
        }
        return intervals.length - count;
    }
}
