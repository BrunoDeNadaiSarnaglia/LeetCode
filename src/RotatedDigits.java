public class rotatedDigits {
  public int rotatedDigits(int N) {
    int count = 0;
    for (int i = 1; i < N; i++) {
      if(!hasInvalidDigits(i) && hasAtLeastOneMirrorDigits(i)) count++;
    }
    return count;
  }

  private boolean hasInvalidDigits(int N) {
    for (int i = N; i > 0; i /= 10) {
      if(i % 10 == 3 || i % 10 == 4 || i % 10 == 7) return false;
    }
    return true;
  }

  private hasAtLeastOneMirrorDigits(int N) {
    for (int i = N; i > 0; i /= 10) {
      if(i % 10 == 2 || i % 10 == 5 || i % 10 == 6 || i % 10 == 9) return true;
    }
    return false;
  }
}
