import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sarnaglia on 9/23/17.
 */
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, (o1, o2) -> o1.length() - o2.length());
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String root = root(dict, words[i]);
            if(root != null) {
                words[i] = root;
            }
        }
        String s = words[0];
        for (int i = 1; i < words.length; i++) {
            s += " " + words[i];
        }
        return s;
    }

    private String root(List<String> dict, String word) {
        for (String root: dict) {
            if(isRoot(root, word))  return root;
        }
        return null;
    }

    private boolean isRoot(String root, String word) {
        if(root.length() > word.length())   return false;
        for (int i = 0; i < root.length(); i++) {
            if(word.charAt(i) != root.charAt(i))    return false;
        }
        return true;
    }
}
