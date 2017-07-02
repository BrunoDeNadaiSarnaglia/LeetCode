import java.util.Arrays;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class DeleteOperationForTwoStrings {


    public static void main(String[] args) {
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        System.out.println(d.maxSubSeq("park", "spake"));
        System.out.println(d.maxSubSeq("food", "money"));
    }

    public int minDistance(String word1, String word2) {
        int maxSubSeq = maxSubSeq(word1, word2);
        return word1.length() + word2.length() - 2 * maxSubSeq;
    }


    private int maxSubSeq(String word1, String word2) {
        int[] dp = new int[word1.length() + 1];
        int max = 0;
        for (int i = 0; i < word2.length(); i++) {
            int[] newDp = new int[word1.length() + 1];
            for (int j = 0; j < word1.length(); j++) {
                if(word1.charAt(j) == word2.charAt(i)) {
                    newDp[j + 1] = dp[j] + 1;
                } else {
                    newDp[j + 1] = Math.max(newDp[j], dp[j + 1]);
                }
            }
            dp = newDp;
        }
        return dp[dp.length - 1];
    }
}
