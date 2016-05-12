/**
 * Created by Bruno on 5/7/2016.
 */
public class SelfCrossing {


    public boolean isSelfCrossing(int[] x){
        for (int i = 0; i < x.length; i++) {
            if(meetParallel(x, i))  return true;
            if(meetSecondParallel(x, i))  return true;
            if(meetLines(x, i))  return true;
        }
        return false;
    }

    private boolean meetParallel(int[] x, int i){
        if(i < 3) return false;
        if(x[i] < x[i - 2]) return false;
        if(x[i - 3] < x[i - 1]) return false;
        return true;
    }

    private boolean meetSecondParallel(int[] x, int i){
        if(i < 5)   return false;
        if(x[i - 2] < x[i - 4]) return false;
        if(x[i] + x[i - 4] < x[i - 2])  return false;
        if(x[i - 1] > x[i - 3]) return false;
        if(x[i - 1] < x[i - 3] - x[i - 5])  return false;
        return true;
    }

    private boolean meetLines(int[] x, int i){
        if(i < 4)   return false;
        if(x[i - 1] != x[i - 3])    return false;
        if(x[i] + x[i - 4] < x[i - 2])  return false;
        return true;
    }

}
