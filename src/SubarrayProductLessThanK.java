public class SubarrayProductLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    long prod = 1;
    int i = 0;
    int j = 0;
    int acc = 0;
    while(i < nums.length) {
      if (i == j && nums[j] > k) {
        i++; j++; prod = 1;
      } else if (j == nums.length || prod * nums[j] >= k) {
        acc += j - i;
        prod /= nums[i++];
      } else {
        prod *= nums[j++];
      }
    }
    return acc;
  }
}
