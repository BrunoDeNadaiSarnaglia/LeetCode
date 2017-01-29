import java.util.*;

/**
 * Created by Sarnaglia on 1/28/17.
 */
public class createMaximumNumber {

    public static void main(String[] args){
        createMaximumNumber c = new createMaximumNumber();
//        System.out.println(Arrays.toString(c.maxNumber(
//                new int[]{3, 4, 6, 5},
//                new int[]{9, 1, 2, 5, 8, 3},
//                5)));
//        System.out.println(Arrays.toString(c.maxNumber(
//                new int[]{6, 7},
//                new int[]{6, 0, 4},
//                5)));
        System.out.println(Arrays.toString(c.maxNumber(
                new int[]{2,5,6,4,4,0},
                new int[]{7,3,8,0,6,5,7,6,2},
                15)));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxNumber(nums1, i), maxNumber(nums2, k - i));
            if(compare(candidate, ans))   ans = candidate;
        }
        return ans;
    }

    private boolean compare(int[] nums1, int[] nums2){
        return compare(nums1, nums2, 0, 0);
    }

    private boolean compare(int[] nums1, int[] nums2, int i, int j){
        for (;i < nums1.length && j < nums2.length && nums1[i] == nums2[j]; i++, j++);
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2){
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length || j < nums2.length){
            merge[k++] = (compare(nums1, nums2, i, j) ? nums1[i++] : nums2[j++]);
        }
        return merge;
    }

    private int[] maxNumber(int[] nums1, int size){
        if(size == 0) return new int[0];
        int[] max = new int[size];
        int i = 0, j = 0;
        while (i < nums1.length){
            if(j == 0 || size - j == nums1.length - i || (j < max.length && nums1[i] <= max[j - 1])){
                max[j++] = nums1[i++];
            } else if(nums1[i] > max[j - 1]){
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
