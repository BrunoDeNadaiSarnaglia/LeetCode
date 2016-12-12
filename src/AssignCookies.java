import java.util.Arrays;

/**
 * Created by Bruno on 12/12/2016.
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            if(s[j] >= g[i]) i++;
            j++;
        }
        return i;
    }

}
