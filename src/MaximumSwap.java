import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Sarnaglia on 9/22/17.
 */
public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap m = new MaximumSwap();
        m.maximumSwap(10);
    }

    public int maximumSwap(int num) {
        if(num <= 9)    return num;
        int len = 0;
        for (; num / (int)Math.pow(10, len) != 0; len++);
        int[] numList = new int[len];
        for (int i = 0; i < len; i++) {
            numList[len - 1 - i] = (num / (int)Math.pow(10, i)) % 10;
        }
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!ll.isEmpty() && numList[ll.getLast()] <= numList[i]) {
                ll.removeLast();
            }
            ll.addLast(i);
        }
        System.out.println(ll);
        int i = 0;
        while (!ll.isEmpty()) {
            if(numList[i] == numList[ll.getFirst()]) {
                if(ll.getFirst() == i){
                    ll.removeFirst();
                }
                i++;
            } else {
                int aux = numList[i];
                numList[i] = numList[ll.getFirst()];
                numList[ll.getFirst()] = aux;
                break;
            }
        }
        System.out.println(Arrays.toString(numList));
        int maxNum = 0;
        for (int j = 0; j < numList.length; j++) {
            maxNum = 10 * maxNum + numList[j];
        }
        return maxNum;
    }
}
