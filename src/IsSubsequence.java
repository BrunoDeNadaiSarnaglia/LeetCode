/**
 * Created by Bruno on 9/11/2016.
 */
public class IsSubsequence {

    public static void main(String[] args){
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
    }


    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}
