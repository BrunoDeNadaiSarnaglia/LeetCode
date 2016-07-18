/**
 * Created by Bruno on 7/17/2016.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int minIdx = minimumSearch(nums);
        int val = search(nums, target, 0, minIdx - 1);
        if(val != -1)   return val;
        return search(nums, target, minIdx, nums.length - 1);
    }

    private int minimumSearch(int[] nums){
        return minimumSearch(nums, 0, nums.length - 1);
    }

    private int minimumSearch(int[] nums, int i, int j){
        if(i == j)  return i;
        int mid = i + (j - i) / 2;
        if(nums[mid] > nums[0]){
            return minimumSearch(nums, mid + 1, j);
        }
        return minimumSearch(nums, i, mid);
    }

    private int search(int[] nums, int target, int i, int j){
        if(i > j)   return -1;
        int mid = i + (j - i) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target)
            return search(nums, target, i, mid - 1);
        return search(nums, target, mid + 1, j);
    }
}
