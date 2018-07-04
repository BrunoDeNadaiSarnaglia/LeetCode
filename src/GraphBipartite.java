import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GraphBipartite {
  public boolean isBipartite(int[][] graphMatrix) {
    HashMap<Integer, HashSet<Integer>> graph = getAdjListGraph(graphMatrix);
    Set<Integer> nodes = graph.keySet().stream().collect(Collectors.toSet());
    HashSet<Integer> setA  = new HashSet<>();
    HashSet<Integer> setB  = new HashSet<>();
    LinkedList<Integer> ll = new LinkedList<Integer>();
    for(int node : nodes) {
      if(!setA.contains(node) && !setB.contains(node)) {
        ll.addLast(node);
        setA.add(node);
        while(!ll.isEmpty()) {
          int next = ll.removeFirst();
          HashSet<Integer> set = setA.contains(next) ? setB : setA;
          HashSet<Integer> neighs = graph.get(next);
          for(int neigh : neighs) {
            if(!setA.contains(neigh) && !setB.contains(neigh)) {
              set.add(neigh);
              ll.addLast(neigh);
            }
            else if(setA.contains(neigh) && set == setB || setB.contains(neigh) && set == setA) return false;
          }
        }
      }
    }
    return true;
  }

  private HashMap<Integer, HashSet<Integer>> getAdjListGraph(int[][] graphMatrix) {
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    for (int i = 0; i < graphMatrix.length; i++) {
      for (int j = 0; j < graphMatrix[i].length; j++) {
        graph.putIfAbsent(i, new HashSet<>());
        graph.get(i).add(j);
      }
    }
    return graph;
  }
}
