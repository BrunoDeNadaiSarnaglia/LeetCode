import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class FindRelativeRank {

    public String[] findRelativeRanks(int[] nums) {
        Integer[] cloneNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cloneNums[i] = nums[i];
        }
        Arrays.sort(cloneNums, Collections.reverseOrder());
        String[] ranks = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = position(binarySearch(cloneNums, nums[i]));
        }
        return ranks;
    }

    private String position(int i) {
        if(i == 0)  return "Gold Medal";
        if(i == 1)  return "Silver Medal";
        if(i == 2)  return "Bronze Medal";
        return i + 1 + "";
    }

    private int binarySearch(Integer[] nums, int target){
        int i = 0;
        int j = nums.length;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] < target){
                j = mid - 1;
            } else if(nums[mid] > target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
