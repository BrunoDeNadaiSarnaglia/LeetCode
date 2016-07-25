import java.util.LinkedList;

/**
 * Created by Bruno on 7/24/2016.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        return Math.max(wiggleMaxLength(nums, 1), wiggleMaxLength(nums, 0) + 1);
    }

    private int wiggleMaxLength(int[] nums, int count) {
        if(nums == null || nums.length == 0)    return count;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if(count % 2 == 1){
                if(nums[i] > nums[idx]){
                    count++;
                }
                idx = i;
            } else {
                if(nums[i] < nums[idx]){
                    count++;
                }
                idx = i;
            }
        }
        return count;
    }
}
