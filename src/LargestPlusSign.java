import java.util.HashSet;

public class LargestPlusSign {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    int[][] grid = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(grid[i], N);
    }

    for (int[] m : mines) {
        grid[m[0]][m[1]] = 0;
    }

    for (int i = 0; i < N; i++) {
      int l = -1;
      for (int j = 0; j < N; j++) {
        if(grid[i][j] == 0) { l = j; }
        grid[i][j] = Math.min(grid[i][j], j - l);
      }
      int r = N;
      for (int j = N - 1; j >= 0; j--) {
        if(grid[i][j] == 0) { r = j; }
        grid[i][j] = Math.min(grid[i][j], r - j);
      }
    }
    for (int j = 0; j < N; j++) {
      int t = -1;
      for (int i = 0; i < N; i++) {
        if(grid[i][j] == 0) { t = i; }
        grid[i][j] = Math.min(grid[i][j], i - t);
      }
      int b = N;
      for (int i = N - 1; i >= 0; i--) {
        if(grid[i][j] == 0) { b = i; }
        grid[i][j] = Math.min(grid[i][j], b - i);
      }
    }
    int res = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            res = Math.max(res, grid[i][j]);
        }
    }

    return res;
  }

}
