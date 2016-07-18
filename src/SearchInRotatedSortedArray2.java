/**
 * Created by Bruno on 7/18/2016.
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int minIdx = findMin(nums, 0, nums.length - 1);
        return search(nums, target, 0, minIdx - 1) != -1 || search(nums, target, minIdx, nums.length - 1) != -1;
    }

    private int search(int[] nums, int target, int i, int j) {
        if(i > j) return -1;
        int mid = i + (j - i) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target)  return search(nums, target, i, mid - 1);
        return search(nums, target, mid + 1, j);
    }


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
