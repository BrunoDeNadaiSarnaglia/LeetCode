import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by Bruno on 10/1/2016.
 */
public class TrapRainWater {

    public static void main(String[] args){
        TrapRainWater t = new TrapRainWater();
        System.out.print(
        t.trapRainWater(new int[][]{
                new int[]{12,13,1,12},
                new int[]{13,4,13,12},
                new int[]{13,8,10,12},
                new int[]{12,13,12,12},
                new int[]{13,13,13,13},
        })
        );
    }

    private class Cell {
        int i;
        int j;
        int height;

        public Cell(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "i=" + i +
                    ", j=" + j +
                    ", height=" + height +
                    '}';
        }
    }

    private int[][] directions = new int[][]{ new int[]{ 0, -1 }, new int[]{ -1, 0 }, new int[]{ 0, 1 }, new int[]{ 1, 0 } };

    public int trapRainWater(int[][] heightMap) {
        boolean[][] hasVisited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });
        for (int i = 0; i < heightMap.length; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            hasVisited[i][0] = true;
            pq.add(new Cell(i, heightMap[0].length-1, heightMap[i][heightMap[0].length-1]));
            hasVisited[i][heightMap[0].length-1] = true;
        }
        for (int i = 0; i < heightMap[0].length; i++) {
            pq.add(new Cell(0, i, heightMap[0][i]));
            hasVisited[0][i] = true;
            pq.add(new Cell(heightMap.length-1, i, heightMap[heightMap.length-1][i]));
            hasVisited[heightMap.length-1][i] = true;
        }
        int floodQuantiy = 0;
        while (!pq.isEmpty()){
            Cell c = pq.poll();
            System.out.println(c);
            for (int[] direction : directions){
                int i = c.i + direction[0];
                int j = c.j + direction[1];
                if(i < 0 || i >= heightMap.length || j < 0 || j >= heightMap[0].length || hasVisited[i][j]) continue;
                hasVisited[i][j] = true;
                floodQuantiy += Math.max(0, c.height - heightMap[i][j]);
                System.out.println(Math.max(0, c.height - heightMap[i][j]));
                pq.add(new Cell(i, j, Math.max(c.height, heightMap[i][j])));
            }
        }
        return floodQuantiy;
    }
}
