import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourSum2 {



    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = map.getOrDefault(A[i] + B[j], 0);
                map.put(A[i] + B[j], sum + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = map.getOrDefault(- C[i] - D[j], 0);
                count += sum;
            }
        }
        return count;
    }

}
