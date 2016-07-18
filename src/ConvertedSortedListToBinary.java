/**
 * Created by Bruno on 7/17/2016.
 */
public class ConvertedSortedListToBinary {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Triplet {
        ListNode firstHalf;
        ListNode middleNode;
        ListNode secondHalf;

        public Triplet(ListNode firstHalf, ListNode middleNode, ListNode secondHalf) {
            this.firstHalf = firstHalf;
            this.middleNode = middleNode;
            this.secondHalf = secondHalf;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        Triplet triplet = bipartiteListNode(head);
        TreeNode root = new TreeNode(triplet.middleNode.val);
        root.left = sortedListToBST(triplet.firstHalf);
        root.right = sortedListToBST(triplet.secondHalf);
        return root;
    }

    private Triplet bipartiteListNode(ListNode head){
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middleNode = slow.next;
        slow.next = null;
        ListNode secondHalf = middleNode.next;
        middleNode.next = null;
        ListNode firstHalf = fakeHead.next;
        return new Triplet(firstHalf, middleNode, secondHalf);
    }



}
