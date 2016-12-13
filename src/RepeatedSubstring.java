import java.util.List;

/**
 * Created by Bruno on 12/13/2016.
 */
public class RepeatedSubstring {

    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if(len % i != 0)    continue;
            if(check(i, len, str))    return true;
        }
        return false;
    }

    private boolean check(int i, int len, String str){
        for (int j = 0; j < i; j++) {
            for (int k = j + i; k < len; k += i) {
                if(str.charAt(j) != str.charAt(k))  return false;
            }
        }
        return true;
    }

}
