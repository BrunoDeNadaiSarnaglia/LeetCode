public class ValidParenthesisString {
  public boolean checkValidString(String s) {
    int quantityOfOpen = s.length() / 2;
    int quantityOfClose = s.length() / 2;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '(') {
        quantityOfOpen--;
      }
      if(s.charAt(i) == ')') {
        quantityOfClose--;
      }
    }
    if(quantityOfOpen < 0 || quantityOfClose < 0) return false;
    int count = 0;
    char[] array = s.toCharArray();
    for (int i = 0; quantityOfOpen > 0 && i < s.length(); i++) {
      if(s.charAt(i) == '*') {
        array[i] = '(';
        quantityOfOpen--;
      }
    }
    for (int i = s.length() - 1; quantityOfClose > 0 && i >= 0; i--) {
      if(s.charAt(i) == '*') {
        array[i] = ')';
        quantityOfClose--;
      }
    }
    for (int i = 0; i < array.length; i++) {
      if(array[i] == '(') {
        count++;
      }
      if(array[i] == ')') {
        count--;
      }
      if(count < 0) return false;
    }
    return true;
  }
}
