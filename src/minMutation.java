import java.util.*;

/**
 * Created by Sarnaglia on 1/27/17.
 */
public class minMutation {


    public static void main(String[] args){
        minMutation m = new minMutation();
        System.out.println(m.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if(!dict.contains(end))    return 0;
        if(hasEdge(start, end)) return 1;
        HashSet<String> startBound = new HashSet<>();
        HashSet<String> endBound = new HashSet<>();
        startBound.add(start);
        endBound.add(end);
        dict.remove(start);
        dict.remove(end);
        int count = 2;
        while (true){
            HashSet<String> intersection;
            if(startBound.size() < endBound.size() || (startBound.size() == endBound.size() && !filter(startBound, dict).isEmpty())){
                intersection = filter(startBound, dict);
                if(!filter(endBound, intersection).isEmpty()){
                    return count;
                }
                startBound = intersection;
            } else {
                intersection = filter(endBound, dict);
                if(!filter(startBound, intersection).isEmpty()){
                    return count;
                }
                endBound = intersection;
            }
            if(intersection.isEmpty())  return -1;
            count++;
            remove(dict, intersection);
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
