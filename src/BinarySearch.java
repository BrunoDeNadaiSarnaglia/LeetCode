/**
 * Created by Sarnaglia on 1/16/17.
 */
public class BinarySearch {


    public int findPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (j < i) {
            int mid = i + (j - i) / 2;
            if(nums[mid] < target) i = mid + 1;
            else if(nums[mid] > target) j = mid - 1;
            else return mid;
        }
        return -1;
    }

}
