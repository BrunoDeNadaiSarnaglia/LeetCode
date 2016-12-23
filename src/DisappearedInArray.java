import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedInArray {

    public static void main(String[] args){
        DisappearedInArray d = new DisappearedInArray();
        d.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length;) {
            if(nums[i] == 0 || i == nums[i] - 1) i++;
            else if(nums[i] == nums[nums[i] - 1]) nums[i++] = 0;
            else swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)    list.add(i + 1);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
