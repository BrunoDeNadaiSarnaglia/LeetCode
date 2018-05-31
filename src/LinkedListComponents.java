import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinkedListComponents {

  private class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public int numComponents(ListNode head, int[] G) {
    IntStream.
    Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toCollection(HashSet::new));
    ListNode p = head;
    int count = set.contains(p.val) ? 1 : 0;
    while(p.next != null) {
      if(!set.contains(p.val) && set.contains(p.next.val)) count++;
      p = p.next;
    }
    return count;
  }
}
