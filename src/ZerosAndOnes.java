/**
 * Created by Bruno on 12/24/2016.
 */
public class ZerosAndOnes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dpMaxFormMatrix = new int[m + 1][n + 1];
        for (String num : strs) {
            for (int i = m; i > 0; i--) {
                for (int j = n; j > 0; j--) {
                    int zeros = countZeros(num);
                    int ones = num.length() - zeros;
                    dpMaxFormMatrix[i][j] = Math.max(
                            dpMaxFormMatrix[i][j],
                            (i - zeros) >= 0 && (j - ones) >= 0 ? dpMaxFormMatrix[i - zeros][j - ones] + 1 : 0
                    );
                }
            }
        }
        return dpMaxFormMatrix[m][n];
    }

    private int countZeros(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += (str.charAt(i) == '0' ? 1 : 0);
        }
        return count;
    }

}
