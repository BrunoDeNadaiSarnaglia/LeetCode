public class LongestWordInDictionary {
  public String longestWord(String[] words) {
    HashSet<String> set =new HashSet<String> ();
    String candidate = "";
    Arrays.sort(words);
    for(String word : words) {
      if(word.length() >= candidate.length()) {
        int i = 1;
        for(; i < word.length(); i++ ) {
          if(!set.contains(word.substring(word.length() - i))) {
            break;
          }
        }
        if(i == word.length()) {
          candidate = word;
        }
      }
      set.add(word);
    }
    return candidate;
  }
}
