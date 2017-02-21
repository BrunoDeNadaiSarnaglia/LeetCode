/**
 * Created by Sarnaglia on 2/14/17.
 */
public class ReversePair2 {

    public static void main(String[] args){
        ReversePair2 r = new ReversePair2();
        System.out.print(r.reversePairs(new int[]{1,3,2,3,1}));
    }

    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int i, int j) {
        if(j <= i)  return 0;
        int mid = i + (j - i) / 2;
        int fh = reversePairs(nums, i, mid);
        int sh = reversePairs(nums, mid +1, j);
        int m = merge(nums, i, j);
        return fh + sh + m;
    }

    private int merge(int[] nums, int i, int j) {
        int mid = i + (j - i) / 2;
        int m = countReverseImportantPair(nums, i, j);
        int iIt = i;
        int jIt = mid + 1;
        int k = 0;
        int[] aux = new int[j - i + 1];
        while (iIt < mid + 1 || jIt < j + 1) {
            if(iIt == mid + 1){
                aux[k++] = nums[jIt++];
            } else if(jIt == j + 1) {
                aux[k++] = nums[iIt++];
            } else if(nums[iIt] <= nums[jIt]){
                aux[k++] = nums[iIt++];
            } else {
                aux[k++] = nums[jIt++];
            }
        }
        for (int l = 0; l <= j - i; l++) {
            nums[l + i] = aux[l];
        }
        return m;
    }

    private int countReverseImportantPair(int[] nums, int i, int j) {
        int mid = i + (j - i) / 2;
        int iIt = i;
        int jIt = mid + 1;
        int m = 0;
        while (iIt <= mid) {
            if(jIt == j + 1){
                m += jIt - (mid + 1);
                iIt++;
            }
            else if(nums[iIt] / 2 > nums[jIt] || (nums[iIt] / 2 == nums[jIt] && nums[jIt] % 2 == 1)){
                jIt++;
            }
            else {
                m += jIt - (mid + 1);
                iIt++;
            }
        }
        return m;
    }

}
