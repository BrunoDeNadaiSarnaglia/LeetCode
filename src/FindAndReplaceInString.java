import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    Map<Integer, String> idxTosources = new HashMap<>();
    Map<Integer, String> idxToTargets = new HashMap<>();
    for (int i = 0; i < indexes.length; i++) {
      if(indexes[i] + sources[i].length() <= S.length() && S.substring(i, i + sources[i].length()).equals(sources[i])) {
        idxTosources.put(indexes[i], sources[i]);
        idxToTargets.put(indexes[i], targets[i]);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length();) {
      if(idxToTargets.containsKey(i)) {
        sb.append(idxToTargets.get(i));
        i += idxTosources.get(i).length();
      } else {
        sb.append(S.charAt(i++));
      }
    }
    return sb.toString();
  }
}
