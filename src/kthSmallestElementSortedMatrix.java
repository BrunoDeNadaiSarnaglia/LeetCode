import java.util.PriorityQueue;

public class kthSmallestElementSortedMatrix {
  private class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return matrix[p1.i][p1.j] - matrix[p2.i][p2.j];
      }
    });
    for (int i = 0; i < Math.min(matrix.length, k); i++) {
      pq.add(new Pair(i, 0));
    }
    for (int i = 0; i < k - 1; i++) {
      Pair p = pq.poll();
      if(p.j + 1 < matrix[p.i].length) {
        pq.add(new Pair(p.i, p.j + 1));
      }
    }
    Pair kthPair = pq.poll();
    return matrix[kthPair.i][kthPair.j];
  }
}
