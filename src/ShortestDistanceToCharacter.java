public class ShortestDistanceToCharacter {
  public int[] shortestToChar(String S, char C) {
    int[] shortestDistance = new int[S.length()];
    int i = -1; // doesn't exist C character before element in 0
    int j = 0;
    int k = 0;
    // for(; S.charAt(j) != C && j < S.length(); j++);
    while(k < S.length()) {
      if(j < S.length() && S.charAt(j) != C) {
        j++;
      } else if(k > j) {
        i = j;
        j = k;
      } else {
        shortestDistance[k] = Math.min(
          (i < 0 ? Integer.MAX_VALUE : k - i),
          (j >= S.length() ? Integer.MAX_VALUE : j - k));
        k++;
      }
    }
    return shortestDistance;
  }
}
