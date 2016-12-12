/**
 * Created by Bruno on 12/12/2016.
 */
public class IslandPerimeter {

    private class BoundsStrategy {

        private int height;
        private int width;

        public BoundsStrategy(int height, int width) {
            this.width = width;
            this.height = height;
        }

        public boolean IsBounds(int i, int j){
            if(i < 0 || i >= this.height)   return false;
            if(j < 0 || j >= this.width)   return false;
            return true;
        }
    }

    public enum CellType {
        Land,
        Sea,
        OutBounds,
    }

    private class GridType{

        private BoundsStrategy boundsStrategy;
        private int[][] grid;

        public GridType(BoundsStrategy boundsStrategy, int[][] grid) {
            this.boundsStrategy = boundsStrategy;
            this.grid = grid;
        }

        public CellType GetType(int i, int j) throws Exception {
            if(!boundsStrategy.IsBounds(i,j)) return CellType.OutBounds;
            if(grid[i][j] == 0) return CellType.Sea;
            if(grid[i][j] == 1) return CellType.Land;
            throw new Exception("Number not mapped to one of the enum CellType options");
        }
    }


    public int islandPerimeter(int[][] grid) throws Exception {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        BoundsStrategy boundsStrategy = new BoundsStrategy(grid.length, grid[0].length);
        GridType gridType = new GridType(boundsStrategy, grid);
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(gridType.GetType(i, j) == CellType.Sea || gridType.GetType(i, j) == CellType.OutBounds) continue;
                perimeter += (gridType.GetType(i + 1, j) == CellType.Sea || gridType.GetType(i + 1, j) == CellType.OutBounds ? 1 : 0);
                perimeter += (gridType.GetType(i - 1, j) == CellType.Sea || gridType.GetType(i - 1, j) == CellType.OutBounds ? 1 : 0);
                perimeter += (gridType.GetType(i, j + 1) == CellType.Sea || gridType.GetType(i, j + 1) == CellType.OutBounds ? 1 : 0);
                perimeter += (gridType.GetType(i, j - 1) == CellType.Sea || gridType.GetType(i, j - 1) == CellType.OutBounds ? 1 : 0);
            }
        }
        return perimeter;
    }
}
