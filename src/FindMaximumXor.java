import java.util.HashSet;

/**
 * Created by Bruno on 12/24/2016.
 */
public class FindMaximumXor {

    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (Integer num : nums) {
                set.add(mask & num);
            }
            int candidate = max | (1 << i);
            for (Integer maskNum : set){
                if(set.contains(maskNum ^ candidate)){
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }

}
