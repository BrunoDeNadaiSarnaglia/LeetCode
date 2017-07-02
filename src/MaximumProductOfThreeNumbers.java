import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers m = new MaximumProductOfThreeNumbers();
        System.out.println(m.maximumProduct(new int[]{1,2,3,4}));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * Math.max(nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1]);
    }
}
