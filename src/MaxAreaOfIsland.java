import java.util.HashSet;

public class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    HashSet<String> set = new HashSet<>();
    int maxSizeIsland = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1) {
          maxSizeIsland = Math.max(maxSizeIsland, dfs(grid, i, j, set));
        }
      }
    }
    return maxSizeIsland;
  }

  private int dfs(int[][] grid, int i, int j, HashSet<String> set) {
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
    if(grid[i][j] == 0) return 0;
    if(set.contains(i + "|" + j)) return 0;
    set.add(i + "|" + j);
    int left = dfs(grid, i, j - 1, set);
    int right = dfs(grid, i, j + 1, set);
    int top = dfs(grid, i + 1, j, set);
    int bottom = dfs(grid, i - 1, j, set);
    return left + right + top + bottom + 1;
  }
}
