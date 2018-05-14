public class BinaryNumberWithAlternatingBits {
  public boolean hasAlternatingBits(int n) {
    while (n >>> 1 != 0) {
      if((((n & 2) >>> 1) ^ (n & 1)) == 0) {
        return false;
      }
      n >>>= 1;
    }
    return true;
  }
}
