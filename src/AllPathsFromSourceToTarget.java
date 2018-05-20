import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer> path = new ArrayList<Integer>();
    path.add(0);
    return allPathsSourceTarget(graph, 0, path);
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph, int i, List<Integer> path) {
    List<List<Integer>> paths = new ArrayList<>();
    if(i == graph.length - 1) {
      paths.add(path);
      return paths;
    }
    for (int nextStep : graph[i]) {
      List<Integer> newPath = new ArrayList<>(path);
      newPath.add(nextStep);
      paths.addAll(allPathsSourceTarget(graph, nextStep, newPath));
    }
    return paths;
  }
}
