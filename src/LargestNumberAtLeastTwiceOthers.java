public class LargestNumberAtLeastTwiceOthers {
  public int dominantIndex(int[] nums) {
    if(nums.length <= 1)  return -1;
    int max = nums[1] > nums [0] ? 1 : 0;
    int secondMax = nums[1] > nums [0] ? 0 : 1;
    for (int i = 2; i < nums.length; i++) {
      if(nums[i] > nums[max]) {
        secondMax = max;
        max = i;
      }
    }
    return nums[max] > 2 * nums[secondMax] ? max : -1;
  }
}
