import java.util.List;

/**
 * Created by Bruno on 7/17/2016.
 */
public class RemoveDuplicatesFromSortedList2 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode p = fakeHead;
        ListNode q = fakeHead;
        while(true){
            if(q.next == null){
                if(p.next == q){
                    p = q;
                }
                break;
            } else if(p.next.val != q.next.val && p.next == q){
                p = q;
            } else if(p.next.val != q.next.val){
                p.next = q.next;
            }
            q = q.next;
        }
        p.next = null;
        return fakeHead.next;
    }
}
