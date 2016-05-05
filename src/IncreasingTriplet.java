/**
 * Created by Bruno on 5/5/2016.
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int oneLen = Integer.MAX_VALUE;
        int twoLen = Integer.MAX_VALUE;
        for(Integer num : nums){
            if(num <= oneLen){
                oneLen = num;
            } else if(num <= twoLen){
                twoLen = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
