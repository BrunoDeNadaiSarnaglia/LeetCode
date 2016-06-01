import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Bruno on 5/31/2016.
 */

public class SummaryRanges {


    public static void main(String[] args){
        SummaryRanges sr = new SummaryRanges();
        for (Integer num : new Integer[]{1, 3, 7, 2, 6}) {
            sr.addNum(num);
        }
        Utils.printArray(sr.getIntervals().toArray());
    }

    HashSet<Integer> set;

    TreeMap<Integer, Interval> tree;

    boolean updated = false;
    List<Interval> list;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new HashSet<Integer>();
        tree = new TreeMap<Integer, Interval>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val))   return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && val + 1 == h){
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
            updated = true;
        } else if(l != null && tree.get(l).end + 1 >= val){
            tree.get(l).end = Math.max(tree.get(l).end, val);;
        } else if(h != null && val + 1 == h){
            tree.get(h).start = val;
            tree.put(val, tree.get(h));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val,val));
            updated = true;
        }
    }

    public List<Interval> getIntervals() {
        if(!updated) return list;
        list = new ArrayList<Interval>(tree.values());
        updated = false;
        return list;
    }

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}