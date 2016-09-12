/**
 * Created by Bruno on 9/12/2016.
 */
public class FindDifference {

    public char findTheDifference(String s, String t) throws Exception {
        int[] charCount = new int[26];
        for (Character ch : s.toCharArray()) {
            charCount[ch - 'a']--;
        }
        for (Character ch : t.toCharArray()) {
            if(++charCount[ch - 'a'] == 1)  return ch;
        }
        throw new Exception("Function Constraint Not Hold");
    }
}
