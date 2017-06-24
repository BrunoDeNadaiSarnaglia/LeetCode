import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Sarnaglia on 6/24/17.
 */
public class FindUnsortedArray {

    public static void main(String[] args) {
        FindUnsortedArray f = new FindUnsortedArray();
        f.findUnsortedSubarray(new int []{1,2,3,3,3,3});
    }

    public int findUnsortedSubarray(int[] nums) {
        LinkedList<Integer> minSeq = minSeq(nums);
        LinkedList<Integer> maxSeq = maxSeq(nums);
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != minSeq.getFirst()) break;
            minSeq.removeFirst();
        }
        int j = nums.length - 1;
        for(; j >= 0; j--) {
            if(nums[j] != maxSeq.getFirst()) break;
            maxSeq.removeFirst();
        }
//        System.out.println("i: " + i);
//        System.out.println("j: " + j);
        return Math.max(j - i + 1, 0);
    }

    private LinkedList<Integer> minSeq(int[] nums) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!ll.isEmpty() && ll.getLast() > nums[i]) {
                ll.removeLast();
            }
            ll.addLast(nums[i]);
        }
//        System.out.println(ll);
        return ll;
    }

    private LinkedList<Integer> maxSeq(int[] nums) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!ll.isEmpty() && ll.getLast() < nums[i]) {
                ll.removeLast();
            }
            ll.addLast(nums[i]);
        }
//        System.out.println(ll);
        return ll;
    }

}
