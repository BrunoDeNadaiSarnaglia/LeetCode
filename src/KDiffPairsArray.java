import java.util.HashSet;

/**
 * Created by Sarnaglia on 3/5/17.
 */
public class KDiffPairsArray {

    public static void main(String[] args){
        KDiffPairsArray k = new KDiffPairsArray();
        k.findPairs(new int[]{1,1,1,2,2}, 1);
    }

    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length <= 1)    return 0;
        if(k < 0)   return findPairs(nums, -k);
        HashSet<Integer> greaterPairElements = new HashSet<>();
        HashSet<Integer> numsElements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!greaterPairElements.contains(nums[i]) && numsElements.contains(nums[i] - k)){
                greaterPairElements.add(nums[i]);
            }
            if(!greaterPairElements.contains(nums[i] + k) && numsElements.contains(nums[i] + k)) {
                greaterPairElements.add(nums[i] + k);
            }
            numsElements.add(nums[i]);
        }
        return greaterPairElements.size();
    }
}
