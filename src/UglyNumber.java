/**
 * Created by Bruno on 6/30/2016.
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if(num == 0)    return false;
        return takeAllFactor(takeAllFactor(takeAllFactor(num, 2), 3), 5) == 1;
    }

    private int takeAllFactor(int num, int div){
        if(num % div != 0)  return num;
        return takeAllFactor(num / div, div);
    }
}
