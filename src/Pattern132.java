import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by Bruno on 12/23/2016.
 */
public class Pattern132 {


    public static void main(String[] args){
        Pattern132 p = new Pattern132();
        p.find132pattern(new int[]{ -2, 1, 1 });
    }

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        Integer[] secondPlaceArray = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            secondPlaceArray[i] = set.floor(nums[i]);
            set.add(nums[i]);
        }
        int[] accumulateSecondPlace = new int[nums.length];
        accumulateSecondPlace[nums.length - 1] = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(secondPlaceArray[i] == null){
                accumulateSecondPlace[i] = accumulateSecondPlace[i + 1];
            } else {
                accumulateSecondPlace[i] = Math.max(accumulateSecondPlace[i + 1], secondPlaceArray[i]);
            }
        }
        int[] thirdPlaceArray = new int[nums.length];
        thirdPlaceArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            thirdPlaceArray[i] = Math.min(thirdPlaceArray[i-1], nums[i]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if(thirdPlaceArray[i] < accumulateSecondPlace[i + 1]) return true;
        }
        return false;
    }

}
