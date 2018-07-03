public class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    int qt5 = 0;
    int qt10 = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        qt5++;
      } else if (bills[i] == 10) {
        if (qt5 == 0) return false;
        qt5--;
        qt10++;
      } else {
        if(qt5 == 0) return false;
        else if(qt10 > 0) {
          qt10--;
          qt5--;
        } else if (qt5 < 3) return false;
        else {
          qt5 -= 3;
        }
      }
    }
    return true;
  }

}
