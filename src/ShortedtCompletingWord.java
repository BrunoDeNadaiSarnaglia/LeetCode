public class ShortedtCompletingWord {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(Character chara : licensePlate.toCharArray()) {
      if(Character.isLetter(chara)) {
        Character ch = Character.toLowerCase(chara);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
    }
    Collections.sort(words, new Comparator<String>() {
      @override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });
    for (String word : words) {
      if(containsLettes(word, new HashMap<Character, Integer>(map))) {
        return word;
      }
    }
    return null;
  }

  private boolean containsLettes(String s, Map<Character, Integer> map) {
    for(Character ch : s.toCharArray()) {
      char lowercaseChar = Character.toLowerCase(ch);
      if(map.containsKey(lowercaseChar)) {
        map.put(lowercaseChar, map.get(lowercaseChar) - 1);
        if(map.get(lowercaseChar) == 0) {
          map.remove(lowercaseChar);
        }
      }
    }
    return map.size() == 0;
  }
}
