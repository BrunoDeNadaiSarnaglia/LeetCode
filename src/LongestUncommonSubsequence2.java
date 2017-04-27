import java.util.*;

/**
 * Created by Sarnaglia on 4/27/17.
 */
public class LongestUncommonSubsequence2 {

    public int findLUSlength(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.putIfAbsent(strs[i], 0);
            map.put(strs[i], map.get(strs[i]) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        HashSet<String> set = new HashSet<>();
        for (String key: map.keySet()) {
            if(map.get(key) == 1){
                pq.add(key);
            } else {
                set.add(key);
            }
        }
        while (!pq.isEmpty()){
            String candidate = pq.poll();
            if(!hasAnyoneContain(set, candidate))   return candidate.length();
        }
        return -1;
    }

    private boolean hasAnyoneContain(HashSet<String> greaters, String smaller) {
        for (String greater: greaters) {
            if(contain(greater, smaller))   return true;
        }
        return false;
    }

    private boolean contain(String greater, String smaller) {
        int i = 0;
        int j = 0;
        while(i < smaller.length() && j < greater.length() && greater.length() - j >= smaller.length() - i) {
            if(smaller.charAt(i) == greater.charAt(j)){
                i++;
            }
            j++;
        }
        return i == smaller.length();
    }

}
