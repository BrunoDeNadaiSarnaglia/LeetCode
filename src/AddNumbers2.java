/**
 * Created by Bruno on 12/23/2016.
 */
public class AddNumbers2 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Rev = revert(l1);
        ListNode l2Rev = revert(l2);
        ListNode sumRev = addTwoNumbersReverted(l1Rev, l2Rev, 0);
        return revert(sumRev);
    }

    private ListNode addTwoNumbersReverted(ListNode l1, ListNode l2, int mod){
        if(l1 == null && l2 == null && mod == 0)    return null;
        int l1Val = (l1 == null ? 0 : l1.val);
        int l2Val = (l2 == null ? 0 : l2.val);
        ListNode l1Next = (l1 == null ? null : l1.next);
        ListNode l2Next = (l2 == null ? null : l2.next);
        ListNode p = new ListNode((l1Val + l2Val + mod) % 10);
        p.next = addTwoNumbersReverted(l1Next, l2Next, (l1Val + l2Val + mod) / 10);
        return p;
    }

    private ListNode revert(ListNode l){
        ListNode p = null;
        while(l != null){
            ListNode q = l;
            l = l.next;
            q.next = p;
            p = q;
        }
        return p;
    }

}
