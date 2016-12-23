/**
 * Created by Bruno on 12/23/2016.
 */
public class HammingTotal {


    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            sum += count * (nums.length - count);
        }
        return sum;
    }


}
