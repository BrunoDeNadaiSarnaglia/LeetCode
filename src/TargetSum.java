/**
 * Created by Sarnaglia on 1/21/17.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int DEFAULT = 1001;
        int[] cache = new int[2 * DEFAULT];
        cache[DEFAULT] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] newCache = new int[2 * DEFAULT];
            for (int j = 2 * DEFAULT - 1; j >= Math.abs(nums[i]); j--) {
                newCache[j] += cache[j - Math.abs(nums[i])];
            }
            for (int j = 0; j < 2 * DEFAULT - Math.abs(nums[i]); j++) {
                newCache[j] += cache[j + Math.abs(nums[i])];
            }
            for (int j = 0; j < 2 * DEFAULT; j++) {
                cache[i] += newCache[j];
            }
        }
        return (DEFAULT + S >= 2 * DEFAULT || DEFAULT + S < 0 ? 0 : cache[DEFAULT + S]);
    }

}
