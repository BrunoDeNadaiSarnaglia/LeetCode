import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bruno on 6/28/2016.
 */
public class LagestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0)    return new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] array = new int[nums.length];
        int[] parent = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            array[i] = 1;
            parent[i] = i;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && array[j] + 1 > array[i]){
                    array[i] = array[j] + 1;
                    parent[i] = j;
                }
            }
            if(array[idx] < array[i]){
                idx = i;
            }
        }
        List<Integer> l = new ArrayList<Integer>();
        while(idx != parent[idx]){
            l.add(nums[idx]);
            idx = parent[idx];
        }
        l.add(nums[idx]);
        Collections.reverse(l);
        return l;
    }

}
