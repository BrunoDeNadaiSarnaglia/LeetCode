import java.util.*;

/**
 * Created by Sarnaglia on 3/25/17.
 */
public class Matrix01 {

    public static void main(String[] args){
        Matrix01 m = new Matrix01();
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0,0,0));
        matrix.add(Arrays.asList(0,1,0));
        matrix.add(Arrays.asList(1,123,1));
        System.out.println(m.updateMatrix(matrix));
    }

    private class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Pair sum(Pair p) {
            return new Pair(i + p.i, j + p.j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        HashSet<Pair> set   = new HashSet<>();
        Stack<Pair> stk     = new Stack<>();
        int m               = matrix.size();
        int n               = matrix.get(0).size();
        Pair[] directions   = new Pair[] {new Pair(1,0), new Pair(-1,0), new Pair(0,1), new Pair(0,-1)};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix.get(i).get(j) == 0){
                    set.add(new Pair(i, j));
                    stk.add(new Pair(i, j));
                }
            }
        }
        int count = 1;
        while (!stk.isEmpty()) {
            Stack<Pair> s = new Stack<>();
            while (!stk.isEmpty()) {
                Pair p = stk.pop();
                for (Pair d : directions) {
                    Pair dp = p.sum(d);
                    if (!set.contains(dp) && inbound(dp, m, n)) {
                        matrix.get(dp.i).set(dp.j, count);
                        s.push(dp);
                        set.add(dp);
                    }
                }
            }
            count++;
            stk = s;
        }
        return matrix;
    }

    private boolean inbound(Pair p, int m, int n){
        return p.i >= 0 && p.i < m && p.j >= 0 && p.j < n;
    }

}
