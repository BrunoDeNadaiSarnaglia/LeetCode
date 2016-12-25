import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Bruno on 12/25/2016.
 */
public class CanIWin {


    public static void main(String[] args){
        CanIWin c = new CanIWin();
        System.out.print(c.canIWin(4, 6));
    }


    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal > (maxChoosableInteger * (maxChoosableInteger + 1)) / 2)    return false;
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        int options = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            options |= (1 << i);
        }
        return canIWin(options, maxChoosableInteger, desiredTotal, cache);
    }

    private boolean canIWin(int options, int maxChoosableInteger, int desiredTotal, HashMap<Integer, Boolean> cache){
        if(cache.containsKey(options)) return cache.get(options);
        boolean canWin = false;
        for (; maxChoosableInteger >= 1 && (options & (1 << maxChoosableInteger)) == 0; maxChoosableInteger--);
        for (int i = maxChoosableInteger; i >= 1; i--) {
            if((options & (1 << i)) == 0){
                continue;
            }
            if(desiredTotal - i <= 0 || !canIWin(options & ~(1 << i), maxChoosableInteger, desiredTotal - i, cache)){
                canWin = true;
                break;
            }
        }
        cache.putIfAbsent(options, canWin);
        return canWin;
    }

}
