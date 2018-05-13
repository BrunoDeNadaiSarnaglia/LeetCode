import java.util.HashSet;

public class UniqueMorseCodeWords {
  private String[] morseCodeDictionary = new String[]{ ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };

  public int uniqueMorseRepresentations(String[] words) {
    HashSet<String> encodedSetOfWords = new HashSet<String>();
    for (String word : words) {
      encodedSetOfWords.add(encode(word));
    }
    return encodedSetOfWords.size();
  }

  private String encode(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      sb.append(morseCodeDictionary[word.charAt(i) - 'a']);
    }
    return sb.toString();
  }
}
