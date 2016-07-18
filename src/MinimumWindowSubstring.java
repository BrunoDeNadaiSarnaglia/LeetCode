import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Bruno on 7/18/2016.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        HashSet<Character> setOfT = getSetOfString(t);
        HashMap<Character, Integer> setOfWindow = getMapOfString(t);
        int i = 0;
        int j = 0;
        int count = 0;
        int max = Integer.MAX_VALUE;
        String str = "";
        while (true){
            if(count >= t.length()){
                char ch = s.charAt(i++);
                if(setOfWindow.containsKey(ch)){
                    int occurence = setOfWindow.get(ch);
                    setOfWindow.put(ch, occurence - 1);
                    if(setOfWindow.get(ch) < 0) count--;
                }
            } else {
                if(j == s.length()) break;
                char ch = s.charAt(j++);
                if(setOfT.contains(ch)){
                    int occurences = setOfWindow.get(ch);
                    setOfWindow.put(ch, occurences + 1);
                    if(setOfWindow.get(ch) <= 0) count++;
                }
            }
            if(count >= t.length() && j - i < max){
                max = j - i;
                str = s.substring(i, j);
            }
        }
        return str;
    }

    private HashMap<Character, Integer> getMapOfString(String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character ch: t.toCharArray()) {
            int occurences = map.getOrDefault(ch, 0);
            map.put(ch, occurences - 1);
        }
        return map;
    }

    private HashSet<Character> getSetOfString(String t){
        HashSet<Character> set = new HashSet<Character>();
        for (Character ch: t.toCharArray()) {
            set.add(ch);
        }
        return set;
    }
}
