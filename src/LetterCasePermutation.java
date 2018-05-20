import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class letterCasePermutation {
  public List<String> letterCasePermutation(String S) {
      return letterCasePermutation(S, "", 0);
  }

  public List<String> letterCasePermutation(String S, String partial, int i) {
    List<String> l = new ArrayList<>();
    if(i == S.length()) {
      l.add(partial);
      return l;
    }
    char ch = S.charAt(i);
    if(ch >= '0' && ch <= '9')  return letterCasePermutation(S, partial + ch, i + 1);
    l.addAll(letterCasePermutation(S, partial + Character.toUpperCase(ch), i + 1));
    l.addAll(letterCasePermutation(S, partial + Character.toLowerCase(ch), i + 1));
    return l;
  }
}
