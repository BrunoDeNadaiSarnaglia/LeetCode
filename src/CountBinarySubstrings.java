public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
    int lastOccurrence = s.charAt(0);
    int numOfZeros = lastOccurrence == '0' ? 1 : 0,
      numOfOnes = lastOccurrence == '1' ? 1 : 0,
      count = 0;
    for (int i = 1; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == lastOccurrence) {
        numOfZeros += lastOccurrence == '0' ? 1 : 0;
        numOfOnes += lastOccurrence == '1' ? 1 : 0;
        count += lastOccurrence == '0' && numOfZeros <= numOfOnes || lastOccurrence == '1' && numOfOnes <= numOfZeros ? 1 : 0;
      } else {
        if(lastOccurrence == '0') {
          numOfOnes = 1;
        } else {
          numOfZeros = 1;
        }
        count += 1;
      }
    }
    return count;
  }
}
