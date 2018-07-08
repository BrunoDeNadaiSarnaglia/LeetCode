public class SingleNumber2 {
  public int singleNumber(int[] nums) {
    int a = 0;
    int b = 0;
    int c = 0;
    for (int i = 0; i < nums.length; i++) {
      int aAux = a & ~(a & nums[i]);
      int bAux = b & ~(b & nums[i]);
      int cAux = c & ~(c & nums[i]);
      aAux |= ~(a | b | b) & nums[i];
      aAux |= (c & nums[i]);
      bAux |= (a & nums[i]);
      cAux |= (b & nums[i]);
      a = aAux;
      b = bAux;
      c = cAux;
    }
    return b;
  }
}
