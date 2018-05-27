import java.util.Comparator;
import java.util.PriorityQueue;

import javax.annotation.processing.Completion;

import javafx.scene.Parent;

public class SwimInRisingWater {

  private class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
  public int swimInWater(int[][] grid) {
    Pair[][] connectedElements = new Pair[grid.length][grid[0].length];
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return grid[p1.i][p1.j] - grid[p2.i][p2.j];
      }
    });
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        pq.add(new Pair(i, j));
      }
    }
    Pair p = null;
    while(!areConnected(connectedElements, 0, 0, connectedElements.length - 1, connectedElements[0].length - 1)) {
      p = pq.poll();
      addElement(connectedElements, p);
    }
    return grid[p.i][p.j];
  }

  private void addElement(Pair[][] connectedElements, Pair p) {
    int i = p.i;
    int j = p.j;
    connectedElements[i][j] = p;
    if(i + 1 < connectedElements.length) {
      connectElement(connectedElements, p, connectedElements[i + 1][j]);
    }
    if(i - 1 >= 0) {
      connectElement(connectedElements, p, connectedElements[i - 1][j]);
    }
    if(j + 1 < connectedElements[0].length) {
      connectElement(connectedElements, p, connectedElements[i][j + 1]);
    }
    if(j - 1 >= 0) {
      connectElement(connectedElements, p, connectedElements[i][j - 1]);
    }
  }

  private void connectElement(Pair[][] connectedElements, Pair p, Pair q) {
    Pair parentP = getRoot(connectedElements, p);
    Pair parentQ = getRoot(connectedElements, q);
    if(parentP == null && parentQ == null) {
      connectedElements[parentQ.i][parentQ.j] = parentP;
    }
  }

  private Pair getRoot(Pair[][] connectedElements, Pair p) {
    if(p == null) return null;
    Pair pair = p;
    while(connectedElements[pair.i][pair.j] != pair) {
      pair = connectedElements[pair.i][pair.j];
    }
    return pair;
  }

  private boolean areConnected(Pair[][] connectedElements, int i, int j, int k, int l) {
    Pair p = connectedElements[i][j];
    Pair q = connectedElements[k][l];
    Pair rootP = getRoot(connectedElements, p);
    Pair rootQ = getRoot(connectedElements, q);
    return rootP != null && rootQ != null && rootP == rootQ;
  }
}
