import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Bruno on 12/13/2016.
 */
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[256];
        List<Integer> l = new ArrayList<Integer>();
        for (Character ch: p.toCharArray()) {
            map[ch]--;
        }
        int i = 0;
        int j = 0;
        int numPositive = 0;
        while (true){
            if(numPositive > 0){
                if(--map[s.charAt(i++)] == 0) numPositive--;
            } else {
                if(j - i == p.length()) l.add(i);
                if(j == s.length()) break;
                if(++map[s.charAt(j++)] > 0) numPositive++;
            }
        }
        return l;
    }
}
