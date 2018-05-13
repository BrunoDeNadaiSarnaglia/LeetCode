import java.util.HashSet;

public class JewelAndStones {
  public int numJewelsInStones(String J, String S) {
    HashSet<Character> jewels = new HashSet<Character>();
    for (Character ch : J.toCharArray()) {
      jewels.add(ch);
    }
    int count = 0;
    for (Character ch : S.toCharArray()) {
      count += (jewels.contains(ch) ? 1 : 0);
    }
    return count;
  }
}
