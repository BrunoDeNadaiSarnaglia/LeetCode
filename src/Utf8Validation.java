public class Utf8Validation {
  public boolean validUtf8(int[] data) {
    for (int i = 0; i < data.length; i++) {
      int j = leadingOnes(data[i]);
      if(j == 1 || j > 4) return false;
      if(i + j != data.length) return false;
      for (int k = 1; k < j; k++) {
        if(leadingOnes(data[k]) != 1) {
          return false;
        }
      }
    }
    return true;
  }

  private int leadingOnes(int data) {
    int count = 0;
    for (int i = 31; i >= 0 && (data & (1 << i)) != 0; i--) {
      count++;
    }
    return count;
  }
}
