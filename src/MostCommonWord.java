import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.split(" ");
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    HashSet<String> set = new HashSet<String>();
    for (String word : banned) { set.add(word); }
    String maxString = "";
    for (String word : words) {
      String sanitizedWord = word.replaceAll("[^a-zA-Z]","").toLowerCase();
      if(!set.contains(sanitizedWord)) {
        map.putIfAbsent(sanitizedWord, 0);
        map.put(sanitizedWord, map.get(sanitizedWord) + 1);
        if(map.get(sanitizedWord) > map.getOrDefault(maxString, 0)) {
          maxString = sanitizedWord;
        }
      }
    }
    return maxString;
  }
}
