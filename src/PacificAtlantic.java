import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Bruno on 10/11/2016.
 */
public class PacificAtlantic {

    public static void main(String[] args){
        PacificAtlantic pa = new PacificAtlantic();
        pa.pacificAtlantic(new int[][]{
                new int[]{1,2,2,3,5},
                new int[]{3,2,3,4,4},
                new int[]{2,4,5,3,1},
                new int[]{6,7,1,4,5},
                new int[]{5,1,1,2,4},
        });
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> l = new ArrayList<int[]>();
        if(matrix ==  null || matrix.length == 0 || matrix[0].length == 0)  return l;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, matrix[0].length - 1, Integer.MIN_VALUE, atlantic);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, 0, j, Integer.MIN_VALUE, pacific);
            dfs(matrix, matrix.length-1, j, Integer.MIN_VALUE, atlantic);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) l.add(new int[]{i,j});
            }
        }
        return l;
    }

    private void dfs(int[][] matrix, int i, int j, int height, boolean[][] visited){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        if(height > matrix[i][j])   return;
        if(visited[i][j])   return;
        visited[i][j] = true;
        dfs(matrix, i + 1, j, matrix[i][j], visited);
        dfs(matrix, i - 1, j, matrix[i][j], visited);
        dfs(matrix, i, j + 1, matrix[i][j], visited);
        dfs(matrix, i, j - 1, matrix[i][j], visited);
    }
}
