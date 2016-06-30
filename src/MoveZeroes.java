/**
 * Created by Bruno on 6/30/2016.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(j == nums.length){
                nums[i++] = 0;
            } else if(nums[j] != 0){
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
    }

}
