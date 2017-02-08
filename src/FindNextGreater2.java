import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class FindNextGreater2 {


    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] nums2 = new int[nums.length];
        int i = 0;
        int max = 0;
        while (i < nums.length + max || !stk.isEmpty()) {
            max = (nums[i % nums.length] > nums[max] ? i : max);
            if(!stk.isEmpty() && nums[stk.peek()] < nums[i % nums.length]){
                nums2[stk.pop()] = nums[i % nums.length];
            } else if (i == nums.length + max) {
                nums2[stk.pop()] = -1;
            } else {
                if(i < nums.length) stk.push(i % nums.length);
                i++;
            }
        }
        return nums2;
    }

}
