/**
 * Created by Bruno on 6/21/2016.
 */
public class countNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += countNumbersWithUniqueDigitsAndFirstDigitNonZero(i);
        }
        return sum;
    }


    private int countNumbersWithUniqueDigitsAndFirstDigitNonZero(int n){
        if(n == 0)  return 1;
        if(n == 1)  return 9;
        int prod = 9;
        for(int i = 9, j = 0; j < n - 1; j++){
            prod *= i--;
        }
        return prod;
    }
}
