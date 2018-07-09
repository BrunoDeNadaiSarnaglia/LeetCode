import java.util.PriorityQueue;

public class kthSmallestPrimeFraction {
  private class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public int[] kthSmallestPrimeFraction(int[] A, int K) {
    PriorityQueue pq = new PriorityQueue<>(K, new Comparator<>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return ((float)(A[p1.i]) / A[p1.j] - (float)(A[p2.i]) / A[p2.j]) < 0 ? -1 : 1;
      }
    });
    for (int j = 0; j < A.length; j++) {
      pq.add(new Pair(0, j));
    }
    for (int i = 0; i < K - 1; i++) {
      Pair p = pq.poll();
      if(p.i + 1 < A.length) {
        pq.add(new Pair(p.i + 1, p.j));
      }
    }
    Pair kthFraction = pq.poll();
    return new int[]{kthFraction.i, kthFraction.j};
  }
}
