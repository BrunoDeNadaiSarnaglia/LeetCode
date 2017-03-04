import java.util.List;

/**
 * Created by Sarnaglia on 3/4/17.
 */
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String max = "";
        int numLetterDictionary = s.length();
        for (String word: d) {
            if((word.length() > max.length() || word.length() == max.length() && word.compareTo(max) < 0)&& word.length() <= numLetterDictionary && canBeFormed(s, word)){
                max = word;
            }
        }
        return max;
    }


    private boolean canBeFormed(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() || j < word.length()){
            if(s.charAt(i) == word.charAt(j)){
                j++;
            }
            i++;
        }
        return j == word.length();
    }

}
