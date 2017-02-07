import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class DiagonalTransverse {


    public static void main(String[] args){
        DiagonalTransverse dt = new DiagonalTransverse();
        dt.findDiagonalOrder(new int[][]{ new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}});
    }

    private class Pair{

        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)    return null;
        Pair[] pairs = new Pair[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pairs[matrix.length * i + j] = new Pair(i, j);
            }
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.i + o1.j != o2.i + o2.j)  return o1.i + o1.j - (o2.i + o2.j);
                int sum = o1.i + o1.j;
                if(sum % 2 == 0){
                    return o1.j - o2.j;
                } else {
                    return o1.i - o2.i;
                }
            }
        });
        int[] diagonalOrderedElements = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            diagonalOrderedElements[i] = matrix[pairs[i].i][pairs[i].j];
        }
        return diagonalOrderedElements;
    }
}
