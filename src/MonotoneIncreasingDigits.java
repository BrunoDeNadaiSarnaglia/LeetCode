public class MonotoneIncreasingDigits {
  public int monotoneIncreasingDigits(int N) {
    int length = getLength(N);
    int decAdj = getFirstDecresingAdj(N, length);
    if (decAdj == length) return N;
    int firstIdx = getFirstIdxEqualToIthPosition(N, i, length);
    int acc = 0;
    for (int i = 0; i < length; i++) {
      acc *= 10;
      if(i < firstIdx) {
        acc += getDigit(N, i, length);
      } else if(i > firstIdx) {
        acc += 9;
      } else {
        acc += getDigit(N, i, length) - 1;
      }
    }
    return acc;
  }

  private int getDigit(int N, int i, int length) {
    return (N / (int) Math.pow(10, length - i - 1)) % 10;
  }

  private int getLength(int N) {
    int i = 0;
    while (N != 0) {
      i++;
      N /= 10;
    }
    return i;
  }

  private int getFirstDecresingAdj(int N, int length) {
    for (int i = 0; i < length - 1; i++) {
      if (getDigit(N, i, length) > getDigit(N, i + 1, length)) {
        return i;
      }
    }
    return length;
  }

  private int getFirstIdxEqualToIthPosition(int N, int i,int length) {
    int j = i - 1;
    for (; j >= 0; j--) {
      if (getDigit(N, i, length) != getDigit(N, j, length)) {
        return j + 1;
      }
    }
    return 0;
  }
}
