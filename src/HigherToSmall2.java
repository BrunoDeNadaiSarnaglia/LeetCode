/**
 * Created by Bruno on 7/16/2016.
 */
public class HigherToSmall2 {

    public static void main(String[] args){
        HigherToSmall2 hts2 = new HigherToSmall2();
        System.out.println(hts2.getMoneyAmount(6));
    }

    int[][] moneyAmountMatrix;

    public int getMoneyAmount(int n){
        moneyAmountMatrix = new int[n + 1][n + 1];
        return getMoneyAmount(1, n);
    }


    private int getMoneyAmount(int i, int j){
        if(i >= j)  return 0;
        if(moneyAmountMatrix[i][j] != 0)    return moneyAmountMatrix[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, k + Math.max(getMoneyAmount(i, k - 1), getMoneyAmount(k + 1, j)));
        }
        moneyAmountMatrix[i][j] = min;
        return min;
    }



}
