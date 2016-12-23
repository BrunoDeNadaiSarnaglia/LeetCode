import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Bruno on 12/23/2016.
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] > 0) set.add(Math.abs(nums[i]));
        }
        List<Integer> l = new ArrayList<Integer>();
        for (int num : set){
            l.add(num);
        }
        return l;
    }


}
