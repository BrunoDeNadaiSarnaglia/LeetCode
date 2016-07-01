/**
 * Created by Bruno on 6/30/2016.
 */
public class BurstBaloon {

    private int[][] map;

    public int maxCoins(int[] nums) {
        map = new int[nums.length + 2][nums.length + 2];
        for(int i = 0; i < nums.length + 2; i++){
            for(int j = 0; j < nums.length + 2; j++){
                map[i][j] = Integer.MIN_VALUE;
            }
        }
        return maxCoins(nums, -1, nums.length);
    }

    private int maxCoins(int[] nums, int i, int j){
        if(j < i)   return 1;
        if(map[i + 1][j + 1] != Integer.MIN_VALUE) return map[i + 1][j + 1];
        int max = 0;
        int left = (i < 0 ? 1 : nums[i]);
        int right = (j >= nums.length ? 1 : nums[j]);
        for(int k = i + 1; k < j; k++){
            max = Math.max(max, left * nums[k] * right + maxCoins(nums, i, k) + maxCoins(nums, k, j));
        }
        map[i + 1][j + 1] = max;
        return max;
    }


}
