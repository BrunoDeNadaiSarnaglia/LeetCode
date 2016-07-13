import java.util.*;

/**
 * Created by Bruno on 7/12/2016.
 */
public class KSmallestPair {

    public static void main(String[] args){
        KSmallestPair kSmallestPair = new KSmallestPair();
        kSmallestPair.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 10);
    }

    private class HashPriorityQueue<T> extends PriorityQueue<T>{

        HashSet<T> set = new HashSet<T>();

        public HashPriorityQueue(Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        public boolean add(T t){
            if(set.contains(t)) return false;
            set.add(t);
            System.out.print(set);
            return super.add(t);
        }

        @Override
        public T poll(){
            T t = super.poll();
            set.remove(t);
            System.out.print(set);
            return t;
        }
    }

    private class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (first != pair.first) return false;
            return second == pair.second;

        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }
    }


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new ArrayList<int[]>();
        int i = 0;
        int j = 0;
        final int[] f = nums1;
        final int[] s = nums2;
        List<int[]> list = new ArrayList<int[]>();
        HashPriorityQueue<Pair> pq = new HashPriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2) {
                return f[o1.first] + s[o1.second] - f[o2.first] + s[o2.second];
            }
        });
        pq.add(new Pair(0,0));
        for (int l = 0; l < k && !pq.isEmpty(); l++) {
            Pair p = pq.poll();
            list.add(new int[]{ p.first, p.second});
            if(p.first < f.length - 1){
                pq.add(new Pair(p.first + 1, p.second));
            }
            if(p.second < s.length - 1){
                pq.add(new Pair(p.first, p.second + 1));
            }
        }
        return list;
    }
}