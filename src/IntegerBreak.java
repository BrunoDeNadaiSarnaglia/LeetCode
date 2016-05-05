import java.util.HashMap;

/**
 * Created by Bruno on 5/5/2016.
 */
public class IntegerBreak {

    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int integerBreak(int n) {
        if(n < 0 || n == 0 || n == 1){
            return 0;
        } else if(n == 2){
            return 1;
        } else if(this.cache.containsKey(n)){
            return this.cache.get(n);
        }
        int max = 0;
        for(int i = n - 1; i >= 2; i--){
            max = Math.max(max, integerBreak(i) * (n - i));
            max = Math.max(max, i * (n - i));
        }
        this.cache.put(n, max);
        return max;
    }

    public static void main(String[] args){
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(10));
    }
}
