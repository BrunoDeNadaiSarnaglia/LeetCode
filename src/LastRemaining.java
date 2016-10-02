/**
 * Created by Bruno on 10/2/2016.
 */
public class LastRemaining {

    public static void main(String[] args){
        LastRemaining l = new LastRemaining();
        l.lastRemaining(9);
    }

    public int lastRemaining(int n) {
        if(n == 1)  return 1;
        return 2 * lastRemainingReversed(n / 2);
    }

    public int lastRemainingReversed(int n){
        if(n == 1)  return 1;
        return 2* lastRemaining((n + 1)/ 2) - 1;
    }

}
