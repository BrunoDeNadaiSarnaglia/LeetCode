public class ReverseBits {
  public int reverseBits(int n) {
    for(i = 0; j = 31; i < j; i++, j--) {
      n = swap(n , i, j);
    }
    return n;
  }

  private swap(int n , int i, int j) {
    if(((1 << i) & n) != 0 && ((1 << j) & n) != 0) return n;
    if(((1 << i) & n) == 0 && ((1 << j) & n) == 0) return n;
    return toogle(toogle(n, i), j);
  }

  private int toogle(int n, int i) {
    return (1 << i)^n;
  }
}
