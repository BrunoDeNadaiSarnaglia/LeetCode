import java.util.Arrays;

/**
 * Created by Bruno on 10/5/2016.
 */
public class Backpack4 {





    public int backPackVI(int[] nums, int target) {
        Arrays.sort(nums);
        return backPackVI(nums, target, new Integer[target + 1]);
    }




    private int backPackVI(int[] nums, int target, Integer[] cache) {
        if(target < 0)  return 0;
        if(target == 0) return 1;
        if(cache[target] != null) return cache[target];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target - nums[i] < 0)    break;
            sum += backPackVI(nums, target - nums[i], cache);
        }
        cache[target] = sum;
        return sum;
    }
}
