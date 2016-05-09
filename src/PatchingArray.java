/**
 * Created by Bruno on 5/9/2016.
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0;
        int i = 0;
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }

}
