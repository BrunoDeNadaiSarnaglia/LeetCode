import java.util.Random;

/**
 * Created by Bruno on 9/14/2016.
 */
public class LinkedListRandomNode {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    private ListNode head;
    private Random rand = new Random();

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode node = this.head;
        int value = 0;
        int count = 0;
        while(node != null){
            value = chooseRandom(value, node.val, count++);
            node = node.next;
        }
        return value;
    }

    private int chooseRandom(int value, int proposedValue, int count){
        int randValue = rand.nextInt(count + 1);
        return (randValue == count ? proposedValue : value);
    }

}
