public class AmbiguousCoordinates {
  public List<String> ambiguousCoordinates(String S) {
      List<String> l = new ArrayList<String>();
      String number = S.substring(1, S.length() - 1);
      for(int i = 0; i < number.length() - 1; i++) {
          String firstNum = number.substring(0,i + 1);
          String secondNum = number.substring(i + 1);
          for(String num1 : getNumbers(firstNum)) {
              for(String num2 : getNumbers(secondNum)) {
          l.add("(" + num1 + ", " + num2 + ")");
              }
          }
      }
      return l;
  }

  private List<String> getNumbers(String number) {
      List<String> l = new ArrayList<String>();
      if(validNumber(number)) {
          l.add(number);
      }
      for(int i = 0; i < number.length() - 1; i++) { // not possible .2
          String decimalNumber = number.substring(0,i + 1) + "." + number.substring(i + 1);
          if(validNumber(decimalNumber)) {
              l.add(decimalNumber);
          }
      }
      return l;
  }

  private boolean validNumber(String number) {
      if(number.indexOf(".") != -1 && number.charAt(number.length() - 1) == '0') {
          return false;  //123.1230 not valid 123.123 valid
      }
      if(number.length() > 1 && number.charAt(0) == '0' && number.charAt(1) != '.') {
          return false; // 00(0) or 0012(12) 00.01 (0.01)
      }
      return true;
  }

}
