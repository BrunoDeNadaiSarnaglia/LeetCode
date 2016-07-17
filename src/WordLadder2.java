import java.util.*;

/**
 * Created by Bruno on 7/17/2016.
 */
public class WordLadder2 {

    public static void main(String[] args){
        WordLadder2 wl = new WordLadder2();
        System.out.println(wl.findLadders("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"))));
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(start.equals(end))   return new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList(start))));
        if(isOneLetterDifferentStrings(start,end))   return new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList(start, end))));
        Set<String> startSet = new HashSet<String>();
        startSet.add(start);
        List<Set<String>> listStart = new ArrayList<Set<String>>();
        listStart.add(startSet);
        Set<String> endSet = new HashSet<String>();
        endSet.add(end);
        List<Set<String>> listEnd = new ArrayList<Set<String>>();
        listEnd.add(endSet);
        Set<String> nextSet;
        while (true){
            if(dict.isEmpty() || endSet.isEmpty() || startSet.isEmpty()) return new ArrayList<List<String>>();
            startSet = listStart.get(listStart.size() - 1);
            endSet = listEnd.get(listEnd.size() - 1);
            List<Set<String>> list;
            Set<String> set;
            if(endSet.size() < startSet.size())  {
                set = endSet;
                list = listEnd;
            } else {
                set = startSet;
                list = listStart;
            }
            nextSet = nextLayer(set, dict);
            if(nextSet.isEmpty())   return new ArrayList<List<String>>();
            minusSet(dict, nextSet);
            if(!isIntersecionEmpty(nextSet, (set == endSet ? startSet : endSet))) break;
            list.add(nextSet);
        }
        List<List<String>> startPaths = getPath(listStart);
        List<List<String>> endPaths = getPath(listEnd);
        return mergePaths(startPaths, endPaths, nextSet);
    }

    private List<List<String>> mergePaths(List<List<String>> startPaths, List<List<String>> endPaths, Set<String> centerElementsSet){
        List<List<String>> mergedPaths = new ArrayList<List<String>>();
        for (List<String> startPath: startPaths) {
            for (List<String> endPath: endPaths) {
                String lastStartPathElement = startPath.get(startPath.size()-1);
                String lastEndPathElement = endPath.get(endPath.size()-1);
                for (String centerElement: centerElementsSet) {
                    if(isOneLetterDifferentStrings(centerElement, lastStartPathElement) && isOneLetterDifferentStrings(centerElement, lastEndPathElement)){
                        List<String> path = new ArrayList<String>(startPath);
                        List<String> endPathReverted = new ArrayList<String>(endPath);
                        Collections.reverse(endPathReverted);
                        path.add(centerElement);
                        path.addAll(endPathReverted);
                        mergedPaths.add(path);
                    }
                }
            }
        }
        return mergedPaths;
    }

    private List<List<String>> getPath(List<Set<String>> listOfSets){
        List<List<String>> listOfPaths = new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>()));
        for (Set<String> set: listOfSets) {
            listOfPaths = nextPath(listOfPaths, set);
        }
        return listOfPaths;
    }

    private List<List<String>> nextPath(List<List<String>> paths, Set<String> set){
        List<List<String>> nextPaths = new ArrayList<List<String>>();
        for (List<String> path: paths) {
            for (String str: set) {
                if(path.size() == 0 || isOneLetterDifferentStrings(path.get(path.size()-1), str)){
                    List<String> newPath = new ArrayList<String>(path);
                    newPath.add(str);
                    nextPaths.add(newPath);
                }
            }
        }
        return nextPaths;
    }

    private Set<String> nextLayer(Set<String> set, Set<String> dict){
        Set<String> nextSet = new HashSet<String>();
        for (String previousStr: set) {
            for (String nextStr: dict) {
                if(isOneLetterDifferentStrings(previousStr, nextStr)){
                    nextSet.add(nextStr);
                }
            }
        }
        return nextSet;
    }

    private void minusSet(Set<String> dict, Set<String> set){
        for (String str: set) {
            dict.remove(str);
        }
    }

    private boolean isIntersecionEmpty(Set<String> set1, Set<String> set2){
        for (String str1: set1) {
            for (String str2: set2) {
                if(isOneLetterDifferentStrings(str1, str2)) return false;
            }
        }
        return true;
    }

    private boolean isOneLetterDifferentStrings(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length())    return false;
        int differenceCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i))    differenceCount++;
        }
        return differenceCount == 1;
    }


}
