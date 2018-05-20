public class MaxIncreaseToKeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] skylineTopBottom = new int[grid[0].length];
    int[] skylineLeftToRight = new int[grid.length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        skylineTopBottom[j] = Math.max(skylineTopBottom[j], grid[i][j]);
        skylineLeftToRight[i] = Math.max(skylineLeftToRight[i], grid[i][j]);
      }
    }
    int sumIncreasedBuildings = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        sumIncreasedBuildings += Math.min(skylineTopBottom[j], skylineLeftToRight[i]) - grid[i][j];
      }
    }
    return sumIncreasedBuildings;
  }
}
