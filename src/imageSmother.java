/**
 * Created by Sarnaglia on 9/16/17.
 */
public class imageSmother {

    int[][] directions = new int[][]{
            new int[] {0,0},
            new int[] {0,1},
            new int[] {1,0},
            new int[] {1,1},
            new int[] {0,-1},
            new int[] {-1,0},
            new int[] {-1,-1},
            new int[] {1,-1},
            new int[] {-1,1},
    };

    public int[][] imageSmoother(int[][] M) {
        int[][] smothedImage = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                smothedImage[i][j] = (int)Math.floor(average(M, i, j));
            }
        }
        return smothedImage;
    }

    private double average(int[][] M, int i, int j) {
        int count = 0;
        int sum = 0;
        for (int[] direction : this.directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(inBound(M, x, y)){
                count++;
                sum += M[x][y];
            }
        }
        return (double)sum / (double)count;
    }

    private boolean inBound(int[][] M, int i, int j) {
        if(i < 0 || i >= M.length)  return false;
        if(j < 0 || j >= M[0].length)   return false;
        return true;
    }
}
