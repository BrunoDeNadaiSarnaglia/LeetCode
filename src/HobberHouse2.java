/**
 * Created by Bruno on 6/30/2016.
 */
public class HobberHouse2 {
    public int houseRobber2(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }

    private int houseRobber(int[] nums, int i, int j){
        if(j < i)   return 0;
        int maxNotContainingLast = 0;
        int maxContainingLast = nums[i];
        for(int k = i + 1; k <= j; k++){
            int aux = maxContainingLast;
            maxContainingLast = maxNotContainingLast + nums[k];
            maxNotContainingLast = Math.max(maxNotContainingLast, aux);
        }
        return Math.max(maxNotContainingLast, maxContainingLast);
    }
}
