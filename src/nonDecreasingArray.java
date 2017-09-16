/**
 * Created by Sarnaglia on 9/16/17.
 */
public class nonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        return ascCheckPossibility(nums) || dscCheckPossibility(nums);
    }
    private boolean ascCheckPossibility(int[] nums) {
        int past = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < past) {
                count++;
                if(count == 2)  return false;
            } else {
                past = nums[i];
            }
        }
        return true;
    }

    private boolean dscCheckPossibility(int[] nums) {
        int past = Integer.MAX_VALUE;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > past) {
                count++;
                if(count == 2)  return false;
            } else {
                past = nums[i];
            }
        }
        return true;
    }
}
