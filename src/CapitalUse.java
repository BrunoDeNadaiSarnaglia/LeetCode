/**
 * Created by Sarnaglia on 2/20/17.
 */
public class CapitalUse {

    public boolean capitalUse(String word) {
        if(word == null || word.length() == 0)  return false;
        int lowercaseCount = countLowercase(word);
        if(lowercaseCount == word.length())   return true;
        char firstChar = word.charAt(0);
        if(lowercaseCount == word.length() - 1 && isUppercase(firstChar))   return true;
        if(countUppercase(word) == word.length())   return true;
        return false;
    }

    private int countLowercase(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            count += (isLowercase(ch) ? 1 : 0);
        }
        return count;
    }

    private int countUppercase(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            count += (isUppercase(ch) ? 1 : 0);
        }
        return count;
    }

    private boolean isUppercase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }


    private boolean isLowercase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
