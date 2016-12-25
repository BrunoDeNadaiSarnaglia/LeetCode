import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Bruno on 12/25/2016.
 */
public class ArithmeticSlicesSubsequence {


    public static void main(String[] args){
        ArithmeticSlicesSubsequence a = new ArithmeticSlicesSubsequence();
//        a.numberOfArithmeticSlices(new int[] {2,4,6,8,10});
//        a.numberOfArithmeticSlices(new int[] {79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,47,47,45,23,26,74,45,67,34,20,33,71,48,96});
        a.numberOfArithmeticSlices(new int[] {79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50});
    }

    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)   return 0;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                if((long)A[i]-A[j]>Integer.MAX_VALUE) continue;
                if((long)A[i]-A[j]<Integer.MIN_VALUE) continue;
                dp[i].put(A[i] - A[j], dp[i].getOrDefault(A[i] - A[j], 0) + dp[j].getOrDefault(A[i] - A[j], 0) + 1);
                sum += dp[j].getOrDefault(A[i] - A[j], 0);
            }
        }
        return sum;
    }

}
