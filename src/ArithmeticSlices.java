/**
 * Created by Bruno on 10/17/2016.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length == 0)   return 0;
        int i = 0;
        int j = 1;
        int sum = 0;
        while(j + 1 < A.length){
            if(A[i + 1] - A[i] == A[j + 1] - A[j]){
                sum += (j + 1) - (i + 1);
            } else {
                i = j++;
            }
        }
        return sum;
    }
}
