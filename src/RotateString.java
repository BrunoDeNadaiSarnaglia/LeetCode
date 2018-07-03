public class RotateString {
  public boolean rotateString(String A, String B) {
    if(A == null || B == null || A.length() != B.length())  return false;
    for (int i = 0; i < A.length(); i++) {
      if(rotateString(A, i, B)) {
        return true;
      }
    }
    return A.length() == 0;
  }

  public boolean rotateString(String A, int i, String B) {
    int length = B.length();
    for (int j = 0; j < length; j++) {
      if(B.charAt(j) != A.charAt((j + i) % length)) {
        return false;
      }
    }
    return true;
  }
}
