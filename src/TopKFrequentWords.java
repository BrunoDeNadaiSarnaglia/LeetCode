import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if(map.get(s1) != map.get(s2)) {
          return - (map.get(s1) - map.get(s2));
        }
        return s1.compareTo(s2);
      }
    });
    for (String word : map.keySet()) {
      pq.add(word);
    }
    List<String> l = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      l.add(pq.poll());
    }
    return l;
  }
}
