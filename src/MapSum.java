import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 9/23/17.
 */
public class MapSum {

    private HashMap<String, Integer> dict = new HashMap<>();
    public MapSum() {

    }

    public void insert(String key, int val) {
        dict.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : dict.keySet()) {
            sum += isPrefix(prefix, key) ? dict.get(key) : 0;
        }
        return sum;
    }

    private boolean isPrefix(String prefix, String s) {
        if(prefix.length() > s.length())    return false;
        for (int i = 0; i < prefix.length(); i++) {
            if(prefix.charAt(i) != s.charAt(i)) return false;
        }
        return true;
    }
}
