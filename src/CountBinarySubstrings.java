public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
    int[] accumulatorCount = new int[2 * s.length() + 1];
    accumulatorCount[s.length()] = 1;
    int acc = 0;
    int countSubString = 0;
    for (int i = 0; i < s.length(); i++) {
      acc += s.charAt(i) == '1' ? 1 : -1;
      countSubString += accumulatorCount[acc + s.length()]++;
    }
    return countSubString;
  }
}
