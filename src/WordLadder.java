import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bruno on 7/16/2016.
 */
public class WordLadder {

    public static void main(String[] args){
        WordLadder wl = new WordLadder();
//        wl.ladderLength("game", "thee", new HashSet<String>(Arrays.asList("frye","heat","tree","thee","game","free","hell","fame","faye")));
        int val = wl.ladderLength("talk", "tail", new HashSet<String>(Arrays.asList("talk","tons","fall","tail","gale","hall","negs")));
        System.out.println(val);
    }

    public int ladderLength(String start, String end, Set<String> dict){
        if(start.equals(end))   return 1;
        Set<String> startSet = new HashSet<String>();
        startSet.add(start);
        Set<String> endSet = new HashSet<String>();
        endSet.add(end);
        int i = 2;
        while (true){
            if(!isIntersecionEmpty(startSet, endSet)) break;
            if(dict.isEmpty() || endSet.isEmpty() || startSet.isEmpty()) return 0;
            if(endSet.size() < startSet.size())  {
                endSet = nextLayer(endSet, dict);
                minusSet(dict, endSet);
            } else {
                startSet = nextLayer(startSet, dict);
                minusSet(dict, startSet);
            }
            i++;
        }
        return i;
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
