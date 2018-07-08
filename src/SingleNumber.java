public class SingleNumber {
  public int singleNumber(int[] nums) {
    int acc = 0;
    for (int i = 0; i < nums.length; i++) {
      acc ^= nums[i];
    }
    return acc;
  }
}
