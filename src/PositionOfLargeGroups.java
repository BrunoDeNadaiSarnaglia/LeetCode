public class PositionOfLargeGroups {
  public List<List<Integer>> largeGroupPositions(String S) {
      return largeGroupPositions(S, 3);
  }

  public List<List<Integer>> largeGroupPositions(String S, int largeThreshold) {
      int i = 0;
      int j = 0;
      List<List<Integer>> largeGroupPositions = new ArrayList<List<Integer>>();
      while(j <= S.length()) {
        if(j == S.length() || S.charAt(j) != S.charAt(i)) {
          int size = j - i;
          if(size >= largeThreshold) {
            List<Integer> tuple = new ArrayList<Integer>();
                  tuple.add(i);
                  tuple.add(j - 1);
            largeGroupPositions.add(tuple);
              }
              i = j;
          }
          j++;
      }
    return largeGroupPositions;
  }
}
