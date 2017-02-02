import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarnaglia on 2/1/17.
 */
public class Majority2 {


    public List<Integer> majorityElement(int[] nums) {
        return majorityElement(nums, 2);
    }

    private List<Integer> majorityElement(int[] nums, int quantity) {
        int[] filtered = nums;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < quantity - 1; i++) {
            int candidate = majorityCandidate(filtered, quantity);
            if(satisfy(nums, candidate, quantity)){
                l.add(candidate);
            } else {
                return l;
            }
            filtered = filter(filtered, candidate);
            if(filtered.length == 0)    return l;
        }
        return l;
    }

    private int majorityCandidate(int[] nums, int quantity) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                candidate = nums[i];
                count = quantity;
            } else if(candidate == nums[i]){
                count += quantity;
            } else {
                count--;
            }
        }
        return candidate;
    }

    private boolean satisfy(int[] nums, int candidate, int quantity){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == candidate? 1 : 0);
        }
        return count > nums.length / quantity;
    }

    private int[] filter(int[] nums, int num){
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != num)  l.add(nums[i]);
        }
        int[] numsFiltered = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            numsFiltered[i] = l.get(i);
        }
        return numsFiltered;
    }

}
