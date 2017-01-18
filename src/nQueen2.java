import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sarnaglia on 1/17/17.
 */
public class nQueen2 {


    public static void main(String[] args){
        nQueen2 nq = new nQueen2();
        System.out.println(nq.solveNQueens(8));
    }

    int solveNQueens(int n) {
        return solveNQueens(0, n, 0, 0, 0, new HashMap<>());
    }

    private int solveNQueens(int k , int n, int leftDiag, int columns, int rightDiag, HashMap<String, Integer> cache){
        if(k == n){
            return 1;
        }
        if(cache.containsKey(k + "|" + leftDiag + "|" + columns + "|" + rightDiag)) return cache.get(k + "|" + leftDiag + "|" + columns + "|" + rightDiag);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(((leftDiag | columns | rightDiag) & (1 << i)) == 0){
                int leftDiagClone = ((leftDiag | (1 << i)) << 1);
                int rightDiagClone = ((rightDiag | (1 << i)) >>> 1);
                int columnsClone = columns | (1 << i);
                sum += solveNQueens(k + 1, n, leftDiagClone, columnsClone, rightDiagClone, cache);
            }
        }
        cache.put(k + "|" + leftDiag + "|" + columns + "|" + rightDiag, sum);
        return sum;
    }
}
