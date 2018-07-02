import java.util.HashMap;
import java.util.HashSet;

public class PiramidTransitionMatrix {
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    HashMap<String, HashSet<Character>> map = new HashMap<>();
    for (String tuple : allowed) {
      map.putIfAbsent(tuple.charAt(0) + "|" + tuple.charAt(1), new HashSet<>());
      map.get(tuple.charAt(0) + "|" + tuple.charAt(1)).add(tuple.charAt(2));
    }
    return pyramidTransition(bottom, map);
  }

  private boolean pyramidTransition(String bottom, HashMap<String, HashSet<Character>> map) {
    if(bottom.length() == 1)  return true;
    HashSet<String> nextRows = getNextRows(bottom, map);
    for(String row : nextRows) {
      System.out.println(row);
      if(pyramidTransition(row, map)) return true;
    }
    return false;
  }

  private HashSet<String> getNextRows(String row, HashMap<String, HashSet<Character>> map) {
    HashSet<String> cache = new HashSet<>();
    getNextRows(row, map, "", cache);
    return cache;
  }

  private void getNextRows(String row, HashMap<String, HashSet<Character>> map, String nextRow, HashSet<String> cache) {
    if (row.length() < 2) {
      cache.add(nextRow);
      return;
    }
    HashSet<Character> chSet = map.getOrDefault(row.charAt(0) + "|" + row.charAt(1), new HashSet<>());
    for (Character ch : chSet) {
      if (nextRow.length() <= 1 || map.containsKey(nextRow.charAt(nextRow.length() - 1) + "|" + ch)) {
        getNextRows(row.substring(1), map, nextRow + ch, cache);
      }
    }
  }
}
