import java.util.*;

/**
 * Created by Sarnaglia on 7/3/17.
 */
public class SmallestRange {

    private class Pair {
        int lst;
        int idx;

        public Pair(int lst, int idx) {
            this.lst = lst;
            this.idx = idx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> l = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                l.add(new Pair(i, j));
            }
        }
        Collections.sort(l, (o1, o2) -> nums.get(o1.lst).get(o1.idx) - nums.get(o2.lst).get(o2.idx));
        int max = nums.get(0).get(0);
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] map = new int[nums.size()];
        boolean shrink = true;
        int i = 0;
        int j = 0;
        while (j < l.size() && getValue(l.get(j), nums) <= max) {
            map[l.get(j++).lst]++;
        }
        int a = getValue(l.get(0), nums);
        int b = getValue(l.get(j - 1), nums);
        while (true) {
            if(shrink) {
                if(b - a > getValue(l.get(j - 1), nums) - getValue(l.get(i), nums)) {
                    b = getValue(l.get(j - 1), nums);
                    a = getValue(l.get(i), nums);
                }
                if(--map[l.get(i++).lst] == 0){
                    shrink = false;
                }
            } else {
                if(j == l.size())   break;
                if(map[l.get(j++).lst]++ == 0){
                    shrink = true;
                }
            }
        }
        return new int[] {a, b};
    }


    private int getValue(Pair p, List<List<Integer>> nums){
        return nums.get(p.lst).get(p.idx);
    }
}
