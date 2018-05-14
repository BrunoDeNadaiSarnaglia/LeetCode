import java.util.Arrays;
import java.util.Set;

public class GoatLatin {
  private final static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

  public String toGoatLatin(String S) {
    StringBuilder sb = new StringBuilder();
    String[] list = S.split(" ");
    for (int i = 0; i < list.length; i++) {
      sb.append(" ");
      sb.append(encodeWord(list[i], i + 1));
    }
    return sb.toString().substring(1);
  }

  private String encodeWord(String word, int idx) {
    StringBuilder sb = new StringBuilder();
    if(vowels.contains(word.charAt(0))) {
      sb.append(word);
    } else {
      sb.append(word.substring(1)).append(word.charAt(0));
    }
    char[] aSeq = new char[idx];
    Arrays.fill(aSeq, 'a');
    sb.append("ma");
    sb.append(aSeq);
    return sb.toString();
  }
}
