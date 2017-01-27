import javax.swing.*;
import java.util.*;

/**
 * Created by Sarnaglia on 1/26/17.
 */
public class FindLadder2 {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(!dict.contains(start) || !dict.contains(end))    return new ArrayList<>();
        if(hasEdge(start, end)) return Arrays.asList(Arrays.asList(start, end));
        HashMap<String, HashSet<String>> startGraph = new HashMap<>();
        HashMap<String, HashSet<String>> endGraph = new HashMap<>();
        HashSet<String> startBound = new HashSet<>();
        HashSet<String> endBound = new HashSet<>();
        startBound.add(start);
        startGraph.put(start, new HashSet<>());
        endBound.add(end);
        endGraph.put(end, new HashSet<>());
        dict.remove(start);
        dict.remove(end);
        while (true){
            HashSet<String> intersection;
            if(startBound.size() <= endBound.size()){
                intersection = filter(startBound, dict);
            } else {
                intersection = filter(endBound, dict);
            }
            if(intersection.isEmpty())  return new ArrayList<>();

            if(startBound.size() <= endBound.size() && filter(endBound, intersection).isEmpty()){
                addGraph(startGraph, startBound, intersection);
                startBound = intersection;
            } else if (startBound.size() > endBound.size() && filter(startBound, intersection).isEmpty()){
                addGraph(endGraph, endBound, intersection);
                endBound = intersection;
            } else {
                addGraph(startGraph, startBound, intersection);
                addGraph(endGraph, endBound, intersection);
                return buildPath(startGraph, endGraph, intersection, start, end);
            }
            remove(dict, intersection);
        }
    }

    private List<List<String>> buildPath(HashMap<String, HashSet<String>> startBound, HashMap<String, HashSet<String>> endBound, HashSet<String> intersection, String start, String end){
        List<List<String>> paths = new ArrayList<>();
        for (String node: intersection) {
            List<List<String>> startPaths = buildPath(startBound, node, start);
            List<List<String>> endPaths = buildPath(endBound, node, end);
            if(startPaths == null || endPaths == null) continue;
            for (List<String> startPath: startPaths) {
                for (List<String> endPath: endPaths) {
                    System.out.print(startPath);
                    System.out.print(endPath);
                    List<String> path = new ArrayList<>();
                    List<String> endPathClone = new ArrayList<>(endPath);
                    endPathClone.remove(endPathClone.size() - 1);
                    path.addAll(startPath);
                    Collections.reverse(endPathClone);
                    path.addAll(endPathClone);
                    paths.add(path);
                }
            }
        }
        return paths;
    }

    private List<List<String>> buildPath(HashMap<String, HashSet<String>> graph, String start, String end){
        if(start.equals(end)) {
            List<List<String>> paths = new ArrayList<>();
            List<String> path = new ArrayList<>();
            path.add(end);
            paths.add(path);
            return paths;
        }
        HashSet<String> nextLevel = graph.get(start);
        List<List<String>> paths = new ArrayList<>();
        for (String node: nextLevel) {
            List<List<String>> nextPaths = buildPath(graph, node, end);
            if(nextPaths == null)   continue;
            paths.addAll(addEndAll(nextPaths, start));
        }
        if(paths.isEmpty()) return null;
        return paths;
    }

    private List<List<String>> addEndAll(List<List<String>> paths, String end){
        for (List<String> path: paths) {
            path.add(end);
        }
        return paths;
    }

    private void addGraph(HashMap<String, HashSet<String>> graph, HashSet<String> bound, HashSet<String> intersection){
        for (String i: intersection) {
            graph.put(i, new HashSet<>());
            for (String b: bound) {
                if(hasEdge(b, i)){
                    graph.get(i).add(b);
                }
            }
        }
    }

    private HashSet<String> filter(HashSet<String> bound, Set<String> dict){
        HashSet<String> intersection = new HashSet<>();
        for (String s : bound) {
            for (String g : dict){
                if(hasEdge(s, g))   intersection.add(g);
            }
        }
        return intersection;
    }

    private void remove(Set<String> dict, HashSet<String> remove){
        for (String s : remove) {
            dict.remove(s);
        }
    }

    private boolean hasEdge(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i) && ++count > 1)   return false;
        }
        return true;
    }
}
