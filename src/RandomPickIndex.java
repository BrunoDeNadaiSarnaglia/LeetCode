import java.util.Random;

/**
 * Created by Bruno on 9/14/2016.
 */
public class RandomPickIndex {


    private int[] nums;
    private Random rand = new Random();

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int i = 0;
        int value = -1;
        int count = 0;
        for(;i < this.nums.length; i++){
            if(this.nums[i] != target)  continue;
            value = chooseRandom(value, i, count++);
        }
        return value;
    }

    private int chooseRandom(int value, int proposedValue, int count){
        int randValue = rand.nextInt(count + 1);
        return (randValue == count ? proposedValue : value);
    }
}
