/**
 * Created by Sarnaglia on 9/22/17.
 */
public class PalindromeSubstrings {

    public int countSubstrings(String s) {
        char[] hashtagSplitedS = new char[2 * s.length() + 1];
        for (int i = 0; i < hashtagSplitedS.length; i++) {
            hashtagSplitedS[i] = i % 2 == 0 ? '#' : s.charAt(i / 2);
        }
        int[] amplitudePalindrome = new int[hashtagSplitedS.length];
        int max = 0;
        int sum = 0;
        for (int i = 1; i < amplitudePalindrome.length; i++) {
            int minAmplitude = 0;
            if(i <= max + amplitudePalindrome[max]) {
                minAmplitude = Math.min(amplitudePalindrome[max - (i - max)], amplitudePalindrome[max] - (i - max));
            }
            int j = minAmplitude + 1;
            while (i - j >= 0 && i + j < amplitudePalindrome.length &&
                    hashtagSplitedS[i - j] == hashtagSplitedS[i + j]) {
                j++;
            }
            amplitudePalindrome[i] = j - 1;
            sum += (amplitudePalindrome[i] + 1) / 2;
            max = max + amplitudePalindrome[max] > i + amplitudePalindrome[i] ? max : i;
        }
        return sum;
    }

}
