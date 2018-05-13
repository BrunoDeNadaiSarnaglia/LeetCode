import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> selfDividingNumbers = new ArrayList<Integer>();
    for (int i = left; i <= right; i++) {
      if(isSelfDividingNumber(i)) selfDividingNumbers.add(i);
    }
    return selfDividingNumbers;
  }

  private boolean isSelfDividingNumber(int num) {
    for (int it = 1; num / it != 0; it *= 10) {
      int digit = (num / it) % 10;
      if(digit == 0 || num % digit != 0) return false;
    }
    return true;
  }
}
