public class MagicSquaresGrid {
  public int numMagicSquaresInside(int[][] grid) {
    int count = 0;
    for (int i = 1; i < grid.length - 1; i++) {
      for (int j = 1; j < grid[0].length - 1; j++) {
        if(grid[i][j] == 5 && isMagic(grid, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isMagic(int[][] grid, int i, int j) {
    for (int k = -1; k <= 1; k++) {
      for (int l = -1; l <= 1; l++) {
        if(grid[i + k][j + l] < 1 || grid[i + k][j + l] > 9) return false;
      }
    }
    return (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1]) == 15
      && (grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]) == 15
      && (grid[i][j - 1] + grid[i][j] + grid[i][j + 1]) == 15
      && (grid[i + 1][j] + grid[i][j] + grid[i - 1][j]) == 15
      && (grid[i + 1][j - 1] + grid[i][j - 1] + grid[i - 1][j - 1]) == 15
      && (grid[i + 1][j + 1] + grid[i][j + 1] + grid[i - 1][j + 1]) == 15
      && (grid[i + 1][j + 1] + grid[i][j] + grid[i - 1][j - 1]) == 15
      && (grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1]) == 15;
  }
}
