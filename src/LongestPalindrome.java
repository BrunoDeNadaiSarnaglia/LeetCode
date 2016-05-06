/**
 * Created by Bruno on 5/6/2016.
 */
public class LongestPalindrome {

    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.print(longestPalindrome.longestPalindrome("aba"));
    }

    public String longestPalindrome(String s) {
        char[] splittedArray = charArraySplited(s);
        int[] palindromLen = palindromeLen(splittedArray);
        int maxIdx = maxValueIdx(palindromLen);
        String longestPalindrome = filterString(splittedArray, maxIdx - palindromLen[maxIdx], maxIdx + palindromLen[maxIdx]);
        return longestPalindrome;
    }

    private char[] charArraySplited(String s){
        char[] array = new char[2 * s.length() + 1];
        array[0] = '#';
        for(int i = 0, j = 1; i < s.length(); i++){
            array[j++] = s.charAt(i);
            array[j++] = '#';
        }
        return array;
    }

    private int[] palindromeLen(char[] splittedString){
        int[] halfSizePalindrome = new int[splittedString.length];
        int centerHalf = 0;
        for(int i = 1; i < splittedString.length; i++){
            if(i <=  centerHalf + halfSizePalindrome[centerHalf]){
                halfSizePalindrome[i] = Math.min(halfSizePalindrome[centerHalf - (i - centerHalf)], centerHalf + halfSizePalindrome[centerHalf] - i);
            }
            if(i + halfSizePalindrome[i] >= centerHalf + halfSizePalindrome[centerHalf]){
                centerHalf = i;
                int j = centerHalf + halfSizePalindrome[centerHalf];
                int k = centerHalf - halfSizePalindrome[centerHalf];
                for(;j + 1 < splittedString.length && k - 1 >=0 && splittedString[j + 1] == splittedString[k - 1]; j++, k--);
                halfSizePalindrome[centerHalf] = j - centerHalf;
            }
        }
        return halfSizePalindrome;
    }

    private int maxValueIdx(int[] array){
        int maxIdx = 0;
        for(int i = 1; i < array.length; i++){
            if(array[maxIdx] < array[i]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private String filterString(char[] array, int i, int j){
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = i; k <= j; k++) {
            if(array[k] == '#') continue;
            stringBuilder.append(array[k]);
        }
        return stringBuilder.toString();
    }
}
