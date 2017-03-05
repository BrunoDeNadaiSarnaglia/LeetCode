import java.util.HashSet;

/**
 * Created by Sarnaglia on 3/5/17.
 */
public class ContinuousSubarraySum {


    public static void main(String[] args) {
        ContinuousSubarraySum c = new ContinuousSubarraySum();
        c.checkSubarraySum(new int[]{23,2,4,6,7}, 6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 1)   return false;
        if(k < 0)   return checkSubarraySum(nums, -k);
        if(k == 0)  return hasTwoNeighbourZero(nums);
        HashSet<Integer> modsIdx = new HashSet<>();
        int sum = 0;
        modsIdx.add(sum);
        sum = (sum + nums[0]) % k;
        modsIdx.add(sum);
        for (int i = 1; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if(modsIdx.contains(sum))   return true;
            else    modsIdx.add(sum);
        }
        return false;
    }

    private boolean hasTwoNeighbourZero(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + nums[i] == 0)  return true;
        }
        return false;
    }
}
