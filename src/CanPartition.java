import java.util.HashSet;

/**
 * Created by Bruno on 10/10/2016.
 */
public class CanPartition {


    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (Integer num: nums) {
            totalSum += num;
        }
        if(totalSum % 2 == 1)    return false;
        int halfSum = totalSum / 2;
        HashSet<Integer> sumSet = new HashSet<Integer>();
        sumSet.add(0);
        for (Integer num : nums){
            if(sumSet.contains(halfSum - num))  return true;
            HashSet<Integer> nextSumSet = new HashSet<Integer>();
            for (Integer sum: sumSet) {
                if(!sumSet.contains(sum + num) && sum + num < halfSum) nextSumSet.add(sum + num);
            }
            for (Integer sum: nextSumSet) {
                sumSet.add(sum);
            }
        }
        return false;
    }

}
