import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoudAndRich {
  public int[] loudAndRich(int[][] richer, int[] quiet) {
    HashMap<Integer, Set<Integer>> inverseGraph = getInverseGraph(richer);
    int[] loudAndRichs = new int[quiet.length];
    for (int i = 0; i < quiet.length; i++) {
      loudAndRich(loudAndRichs, i, inverseGraph, quiet);
    }
    return loudAndRichs;
  }

  private void loudAndRich(int[] loudAndRichs, int node, HashMap<Integer, Set<Integer>> graph, int[] quiet) {
    if(loudAndRichs[node] != 0) return;
    Set<Integer> adjacents = graph.getOrDefault(node, new HashSet<>());
    int louderIdx = node;
    for (Integer adjacent : adjacents) {
      loudAndRich(loudAndRichs, adjacent, graph, quiet);
    }
    for (Integer adjacent : adjacents) {
      if(quiet[loudAndRichs[adjacent]] < quiet[louderIdx]) {
        louderIdx = loudAndRichs[adjacent];
      }
    }
    loudAndRichs[node] = louderIdx;
  }

  private HashMap<Integer, Set<Integer>> getInverseGraph(int[][] richer) {
    HashMap<Integer, Set<Integer>> inverseGraph = new HashMap<>();
    for (int[] tuple : richer) {
      int dest = tuple[0];
      int origin = tuple[1];
      inverseGraph.putIfAbsent(origin, new HashSet<>());
      inverseGraph.get(origin).add(dest);
    }
    return inverseGraph;
  }

  private HashSet<Integer> getGreatersOrEqual(HashMap<Integer, Set<Integer>> graph, int node) {
    HashSet<Integer> cache = new HashSet<>();
    return getGreatersOrEqual(graph, node, cache);
  }

  private HashSet<Integer> getGreatersOrEqual(HashMap<Integer, Set<Integer>> graph, int node, HashSet<Integer> cache) {
    if(cache.contains(node))  return cache;
    cache.add(node);
    Set<Integer> adjacents = graph.getOrDefault(node, new HashSet<>());
    for (Integer adjacent : adjacents) {
      getGreatersOrEqual(graph, adjacent, cache);
    }
    return cache;
  }

  private int getLouder(List<Integer> candidates, int[] quiet) {
    int louderIdx = candidates.get(0);
    for (int i = 1; i < candidates.size(); i++) {
      int candidate = candidates.get(i);
      if(quiet[candidate] < quiet[louderIdx]) {
        louderIdx = candidate;
      }
    }
    return louderIdx;
  }
}
