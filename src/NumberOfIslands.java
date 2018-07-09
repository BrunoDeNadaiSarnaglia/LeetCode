public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int[][] visited = new grid[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if(dfs(grid, visited, i, j)) {
          count ++;
        }
      }
    }
  }

  private boolean dfs(char[][] grid, int[][] visited, int i, int j) {
    if(!isInbound(grid, i, j)) return false;
    if(visited[i][j]) return false;
    visited[i][j] = true;
    if(grid[i][j] == '0') return false;
    dfs(grid, visited, i + 1, j);
    dfs(grid, visited, i - 1, j);
    dfs(grid, visited, i, j + 1);
    dfs(grid, visited, i, j - 1);
    return true;
  }

  private boolean isInbound(char[][] grid, int i, int j) {
    if(i < 0 || i >= grid.length) return false;
    if(j < 0 || j >= grid[i].length)  return false;
    return true;
  }
}
