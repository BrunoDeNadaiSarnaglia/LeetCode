/**
 * Created by Sarnaglia on 3/26/17.
 */
public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length -1);
    }

    private int singleNonDuplicate(int[] nums, int i, int j) {
        if(i == j)  return i;
        int m = i + 2 * ((j - i) / 4);
        if(nums[m] == nums[m + 1]){
            return singleNonDuplicate(nums, m + 2, j);
        }
        return singleNonDuplicate(nums, i, m);
    }
}
