import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sarnaglia on 1/16/17.
 */
public class nQueen {

    public static void main(String[] args){
        nQueen nq = new nQueen();
        System.out.println(nq.solveNQueens(8));
    }

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        return solveNQueens(0, n, 0, 0,0);
    }


    private ArrayList<ArrayList<String>> solveNQueens(int k , int n, int leftDiag, int columns, int rightDiag){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        if(k == n){
            list.add(new ArrayList<>());
            return list;
        }
        for (int i = 0; i < n; i++) {
            if(((leftDiag | columns | rightDiag) & (1 << i)) == 0){
                int leftDiagClone = ((leftDiag | (1 << i)) << 1);
                int rightDiagClone = ((rightDiag | (1 << i)) >>> 1);
                int columnsClone = columns | (1 << i);
                ArrayList<ArrayList<String>> res = solveNQueens(k + 1, n, leftDiagClone, columnsClone, rightDiagClone);
                String row = getRow(n, i);
                for (ArrayList<String> matrix : res) {
                    matrix.add(row);
                    list.add(matrix);
                }
            }
        }
        return list;
    }

    private String getRow(int n, int i){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if(j == i){
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }

}
