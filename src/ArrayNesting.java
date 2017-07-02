import java.util.HashSet;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        HashSet<Integer> visitedNodes = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(visitedNodes.contains(nums[i]))  continue;
            int count = 0;
            int j = i;
            while (!visitedNodes.contains(nums[j])) {
                count++;
                visitedNodes.add(nums[j]);
                j = nums[j];
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
