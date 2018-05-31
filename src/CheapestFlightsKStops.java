import java.util.HashMap;

public class CheapestFlightsKStops {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(src, 0);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= K; i++) {
      HashMap<Integer, Integer> mapAux = i >= K ? map : new HashMap<>();
      for (int j = 0; j < flights.length; j++) {
        int p1 = flights[j][0];
        int p2 = flights[j][1];
        int edge = flights[j][2];
        if(map.containsKey(p1)) {
          int cost = Math.min(map.get(p1) + edge, map.getOrDefault(p2, Integer.MAX_VALUE));
          mapAux.put(p2, cost);
        }
      }
      map = mapAux;
      min = Math.min(map.getOrDefault(dst, Integer.MAX_VALUE), min);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
