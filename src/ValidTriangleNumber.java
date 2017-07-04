import java.util.Arrays;

/**
 * Created by Sarnaglia on 7/3/17.
 */
public class ValidTriangleNumber {


    public static void main(String[] args) {
        ValidTriangleNumber v = new ValidTriangleNumber();
        v.triangleNumber(new int[] {1,2,3,4,5,6});
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if(0 == nums[i])  continue;
            for (int j = i + 1, k = j + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[k] < nums[i] + nums[j]){
                    k++;
                }
                count += k - j - 1;
            }
        }
        System.out.println(count);
        return count;
    }
}
