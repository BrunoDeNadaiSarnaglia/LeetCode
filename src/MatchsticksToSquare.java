import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Bruno on 12/25/2016.
 */
public class MatchsticksToSquare {

    public static void main(String[] args){
        MatchsticksToSquare m = new MatchsticksToSquare();
        System.out.print(m.makesquare(new int[]{1,1,2,2,2}));
    }

    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        return makesquare(nums, 4);
    }

    private boolean makesquare(int[] nums, int num) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 4 != 0)    return false;
        Arrays.sort(nums);
        return makesquareHelp(nums, new int[num], nums.length - 1, sum / 4);
    }

    private boolean makesquareHelp(int[] nums, int[] sums, int index, int target) {
        int missingTargetSums = 0;
        for (int i = 0; i < sums.length; i++) {
            if(sums[i] != target){
                ++missingTargetSums;
                if(missingTargetSums > 1)
                    break;
            }
        }
        if(missingTargetSums <= 1)  return true;
        for (int i = 0; i < sums.length; i++) {
            sums[i] += nums[index];
            if(sums[i] <= target && makesquareHelp(nums, sums, index - 1, target))   return true;
            sums[i] -= nums[index];
        }
        return false;
    }


}
