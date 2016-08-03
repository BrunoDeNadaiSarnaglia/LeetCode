import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Bruno on 8/3/2016.
 */
public class KthSmallest {

    private class Pair<K, T> {

        private K first;
        private T second;

        public Pair(K first, T second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {

            return first;
        }

        public void setFirst(K first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }

    public int kthSmallest(final int[][] matrix, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return matrix[p1.getFirst()][p1.getSecond()] - matrix[p2.getFirst()][p2.getSecond()];
            }
        });
        pq.add(new Pair<Integer, Integer>(0,0));
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = pq.poll();
            if(p.getSecond() != matrix[0].length - 1)   pq.add(new Pair<Integer, Integer>(p.getFirst(), p.getSecond() + 1));
            if(p.getSecond() == 0 && p.getFirst() != matrix.length - 1)   pq.add(new Pair<Integer, Integer>(p.getFirst() + 1, p.getSecond()));
        }
        return matrix[pq.peek().getFirst()][pq.peek().getSecond()];
    }
}
