import java.util.Arrays;

/**
 * Created by Bruno on 12/23/2016.
 */
public class MinMoves2 {

    public static void main(String[] args){
        MinMoves2 m = new MinMoves2();
        m.minMoves2(new int[]{1,0,0,8,6});
    }


    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j){
            count += nums[j--] - nums[i++];
        }
        return count;
    }
}
