import java.util.HashMap;

/**
 * Created by Bruno on 5/7/2016.
 */
public class ValidAnagram {

        public boolean isAnagram(String s, String t) {
            if(s == null && t == null)  return true;
            if(s == null || t == null)  return false;
            if(s.length() != t.length())    return false;
            int[] map = new int[256];
            for (Character ch : s.toCharArray()) {
                map[ch]++;
            }
            for (Character ch : t.toCharArray()) {
                if(--map[ch] < 0){
                    return false;
                }
            }
            return true;
        }
}
