import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sarnaglia on 7/5/17.
 */
public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new LinkedList<>());
        }
        for (int i = 0; i < ring.length(); i++) {
            map.get(ring.charAt(i)).add(i);
        }
        int[] dp = new int[ring.length()];
        if(map.get(ring.charAt(0)).size() == 0) return -1;
        for (int i = 0; i < map.get(key.charAt(0)).size(); i++) {
            int idx = map.get(key.charAt(0)).get(i);
            dp[idx] = Math.min(idx, ring.length() - idx);
        }
        for (int i = 1; i < key.length(); i++) {
            HashMap<Integer, Integer> newDp = new HashMap<>();
            if(map.get(key.charAt(i)).size() == 0 || map.get(key.charAt(i - 1)).size() == 0)  return -1;
            for (int j = 0; j < map.get(key.charAt(i)).size(); j++) {
                int nextIdx = map.get(key.charAt(i)).get(j);
                for (int k = 0; k < map.get(key.charAt(i - 1)).size(); k++) {
                    int previousIdx = map.get(key.charAt(i - 1)).get(k);
                    int pathAcc = dp[previousIdx];
                    int way = Math.min(Math.abs(nextIdx - previousIdx), ring.length() - Math.abs(nextIdx - previousIdx));
                    newDp.putIfAbsent(nextIdx, pathAcc + way);
                    newDp.put(nextIdx, Math.min(newDp.get(nextIdx), pathAcc + way));
                }
            }
            for (Integer idx: newDp.keySet()) {
                dp[idx] = newDp.get(idx);
            }
        }
        char lastCharacter = ring.charAt(ring.length() - 1);
        int min = Integer.MAX_VALUE;
        for (Integer idx: map.get(lastCharacter)) {
            min = Math.min(min, dp[idx]);
        }
        return min + key.length();
    }

}
