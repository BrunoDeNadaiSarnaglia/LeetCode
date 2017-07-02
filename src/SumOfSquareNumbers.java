/**
 * Created by Sarnaglia on 7/2/17.
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i < (int) Math.sqrt(c); i++) {
            if(isPerfectSquare(c - i * i)){
                return true;
            }
        }
        return false;
    }

    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
