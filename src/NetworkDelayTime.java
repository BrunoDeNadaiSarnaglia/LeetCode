import java.util.HashMap;
import java.util.TreeMap;

import com.apple.concurrent.Dispatch.Priority;
import com.sun.org.apache.regexp.internal.recompile;

public class NetworkDelayTime {
  public int networkDelayTime(int[][] times, int N, int K) {
    TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();
    Integer[] map = new Integer[N + 1];
    map[K] = 0;
    ts.add(K, 0);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < times.length; j++) {
        int originNode = getOriginNode(times[j]);
        int targetNode = getTargetNode(times[j]);
        int cost = getCost(times[j]);
        if(map[originNode] != null) {
          map[targetNode] = Math.min(map[originNode] + cost, map[targetNode] == null ? Integer.MAX_VALUE : map[targetNode]);
        }
      }
    }
    int max = 0;
    for (int i = 1; i < map.length; i++) {
      if(map[i] ==  null) return -1;
      max = Math.max(max, map[i]);
    }
    return max;
  }

  private int getOriginNode(int[] edge) {
    return edge[0];
  }

  private int getTargetNode(int[] edge) {
    return edge[1];
  }

  private int getCost(int[] edge) {
    return edge[2];
  }
}
