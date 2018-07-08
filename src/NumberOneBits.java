public class NumberOneBits {
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0, j = 1; i < 32; i++, j <<= 1) {
      count += (n & j) != 0 ? 1 : 0;
    }
    return count;
  }
}
