import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    Integer[] beginning = new Integer[26];
    Integer[] ending = new Integer[26];
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if(beginning[ch - 'a'] == null) {
        beginning[ch - 'a'] = i;
      }
      ending[ch - 'a'] = i;
    }
    int beginPartition = 0;
    HashSet<Character> set = new HashSet<>();
    List<Integer> partitionLabel = new ArrayList<>();

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if(beginning[ch - 'a'] == i) {
        set.add(ch);
      }
      if(ending[ch - 'a'] == i) {
        set.remove(ch);
      }
      if(set.size() == 0) {
        partitionLabel.add(i - beginPartition + 1);
        beginPartition = i + 1;
      }
    }
    return partitionLabel;
  }
}
