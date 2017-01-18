
/**
 * Created by Sarnaglia on 1/15/17.
 */
public class LagestPalindromeProduct {

    public int largestPalindrome(int n) {
        if(n == 1)  return 9;
        long upperBound = (long) Math.pow(10, n) - 1;
        long lowerBound = (long) Math.pow(10, n - 1) - 1;
        long mask = (upperBound * upperBound) / ((long) Math.pow(10, n));
        long minMask = (long) Math.pow(10, n - 1);
        for (long i = mask; i >= minMask ; i--) {
            long num = getNum(i);
            for (long j = Math.min(num / lowerBound, upperBound); j >= lowerBound; j--) {
                if(num % j == 0) return (int) num % 1337;
                if(num / j > upperBound)   break;
            }
        }
        return 0;
    }

    private long getNum(long mask){
        long num = mask;
        while (mask > 0){
            num = 10 * num + mask % 10;
            mask /= 10;
        }
        return num;
    }

}
