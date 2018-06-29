public class MaximizeDistanceClosestPerson {
  public int maxDistToClosest(int[] seats) {
    int leftNeigh = -seats.length;
    int rightNeigh = getNextSeatedIdx(seats, 0);
    int max = 0;
    for (int i = 0; i < seats.length; i++) {
      if(i > rightNeigh) {
        leftNeigh = rightNeigh;
        rightNeigh = getNextSeatedIdx(seats, i);
      }
      max = Math.max(max, Math.min(i - leftNeigh, rightNeigh - i));
    }
    return max;
  }

  private int getNextSeatedIdx(int[] seats, int i) {
    for(; i < seats.length && seats[i] == 0; i++);
    return i < seats.length ? i : 2 * seats.length;
  }
}
