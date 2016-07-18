import java.util.HashMap;

/**
 * Created by Bruno on 7/18/2016.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int high = 0;
        int i = 0;
        int max = 0;
        int offset = s.length();
        int[] map = new int[2 * offset];
        for (int j = 0; j < map.length; j++) {
            map[j] = -1;
        }
        for (Character ch: s.toCharArray()) {
            if(ch == '('){
                if(map[offset + high] == -1) map[offset + high] = i;
                high++;
            } else if(ch == ')'){
                if(map[offset + high] != -1)   map[offset + high] = -1;
                high--;
                if(map[offset + high] != -1 && i - map[offset + high] + 1 > max){
                    max = i - map[offset + high] + 1;
                }
            }
            i++;
        }
        return max;
    }
}
