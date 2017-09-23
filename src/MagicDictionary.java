/**
 * Created by Sarnaglia on 9/23/17.
 */
public class MagicDictionary {

    private String[] dict;
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dict = dict;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < this.dict.length; i++) {
            if(hasOneDifferente(this.dict[i], word))    return true;
        }
        return false;
    }

    private boolean hasOneDifferente(String test, String word) {
        if(test.length() != word.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count += word.charAt(i) != test.charAt(i) ? 1 : 0;
            if(count > 1)   return false;
        }
        return count == 1;
    }
}
