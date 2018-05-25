public class Solution {
  public ListNode[] splitListToParts(ListNode head, int numParts) {
    int len = getLength(head);
    int sizeEachPart = len / numParts;
    int remainder = len % numParts;
    ListNode[] listNodes = new ListNode[numParts];
    ListNode p = head;
    for(int i = 0; i < numParts; i++) {
      ListNode node = null;
      listNodes[i] = p;
      for(int j= 0; j <  sizeEachPart; j++) {
        node = p;
        p = p.next;
      }
      if(remainder != 0) {
        node = p;
        p = p.next;
        remainder--;
      }
      if(node != null) {
        node.next = null;
      }
    }
    return listNodes;
  }

  public int getLength(ListNode head) { // time O(n), memory O(1)
    int len = 0;
    ListNode p = head;
    while(p != null) {
      p = p.next;
      len++;
    }
    return len;
  }
}
