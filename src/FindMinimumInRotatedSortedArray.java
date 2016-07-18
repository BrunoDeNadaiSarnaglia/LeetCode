/**
 * Created by Bruno on 7/18/2016.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int i, int j) {
        if(i == j)  return i;
        if(nums[i] == nums[j]) return findMin(nums, ++i, j);
        int mid = i + (j - i) / 2;
        if(nums[mid] > nums[0]) return findMin(nums, mid + 1, j);
        return findMin(nums, i, mid - 1);
    }
}
