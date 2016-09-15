/**
 * Created by Bruno on 9/15/2016.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            if(numbers[i] + numbers[j] > target){
                j--;
            } else if(numbers[i] + numbers[j] < target){
                i++;
            } else {
                return new int[]{i, j};
            }
        }
        return null;
    }

}
