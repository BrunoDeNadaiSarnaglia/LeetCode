/**
 * Created by Sarnaglia on 3/25/17.
 */
public class ReverseString2 {

    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int i = 0;
        while (i < s.length()){
            int l = i;
            int j = Math.min(l + k, s.length()) - 1;
            while (l < j){
                swap(array, l++, j--);
            }
            i += 2*k;
        }
        return new String(array);
    }


    private void swap(char[] s, int i, int j){
        char aux    = s[i];
        s[i]        = s[j];
        s[j]        = aux;
    }
}
