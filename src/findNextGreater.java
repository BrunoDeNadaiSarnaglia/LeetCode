import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class findNextGreater {


    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> nextGreaterMap = getNextGreaterMap(nums);
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = nextGreaterMap.get(findNums[i]);
        }
        return findNums;
    }

    private Map<Integer, Integer> getNextGreaterMap(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length || !stk.isEmpty()) {
            if(i == nums.length){
                map.put(nums[stk.pop()], -1);
            } else if(stk.isEmpty() || nums[stk.peek()] > nums[i]){
                stk.push(i++);
            } else {
                map.put(nums[stk.pop()], nums[i]);
            }
        }
        return map;
    }

}
