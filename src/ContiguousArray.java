import java.util.HashMap;

/**
 * Created by Sarnaglia on 2/20/17.
 */
public class ContiguousArray {

    public static void main(String[] args){
        ContiguousArray ca = new ContiguousArray();
        ca.ContiguousArray(new int[]{0, 1, 0});
    }

    public int ContiguousArray(int[] array) {
        int max = 0;
        HashMap<Integer, Integer> preSumToFstIdx = new HashMap<>();
        int preSum = 0;
        preSumToFstIdx.put(preSum, 0);
        for (int i = 0; i < array.length; i++) {
            preSum += (array[i] == 0 ? 1 : -1);
            if(preSumToFstIdx.containsKey(preSum))  max = Math.max(max, i + 1 - preSumToFstIdx.get(preSum));
            else    preSumToFstIdx.put(preSum, i + 1);
        }
        return max;
    }
}
