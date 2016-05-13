/**
 * Created by Bruno on 5/12/2016.
 */
public class MaxNum {

    public static void main(String[] args){
        MaxNum maxNum = new MaxNum();
        maxNum.maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1.length < nums2.length )    return maxNumber(nums2, nums1, k);
        int m = nums1.length;
        int n = nums2.length;
        int[] max = new int[k];
        for(int i = 0; i <= k && i <= m; i++){
            if(k - i > n)  continue;
            int[] maxNums1 = maxSingleArray(nums1, i);
            int[] maxNums2 = maxSingleArray(nums2, k - i);
            int[] mergedNum = merge(maxNums1, maxNums2);
            Utils.printArray(maxNums1);
            Utils.printArray(maxNums2);
            Utils.printArray(mergedNum);
            if(greater(mergedNum, max)) max = mergedNum;
        }
        return max;
    }

    private boolean greater(int[] num1, int[] nums2){
        return greater(num1, 0, nums2, 0);
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) { i++; j++; }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums = new int[nums1.length + nums2.length];
        while(k < nums1.length + nums2.length){
            nums[k++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return nums;
    }


    private int[] maxSingleArray(int[] nums, int k){
        int[] newNum = new int[k];
        int n = nums.length;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while(n-i > k-j && j > 0 && newNum[j-1] < nums[i])  j--;
            if(j < k) newNum[j++] = nums[i];
        }
        return newNum;
    }
}
