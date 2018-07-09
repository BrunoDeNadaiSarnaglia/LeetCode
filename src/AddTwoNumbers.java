public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2, int decimal) {
    if(l1 == null && l2 == null)  return null;
    int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + decimal;
    ListNode node = new ListNode(sum % 10);
    node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
    return node;
  }
}
