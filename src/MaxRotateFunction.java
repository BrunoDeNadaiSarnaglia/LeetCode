/**
 * Created by Bruno on 9/11/2016.
 */
public class MaxRotateFunction {

    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0)  return 0;
        long sum = 0;
        long inc = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long) i * (long) A[i];
            inc += (long) A[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            max = Math.max(max, (int)sum);
            sum += inc - A[i] * A.length;
        }
        return max;
    }


}
