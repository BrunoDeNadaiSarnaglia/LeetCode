/**
 * Created by Bruno on 9/11/2016.
 */
public class IntegerReplacement {

    public static void main(String[] args){
        IntegerReplacement i = new IntegerReplacement();
        i.integerReplacement(2147483647);
    }

    public int integerReplacement(int n) {
        return aux(n);
    }

    private int aux(long n){
        if(n == 1)  return 0;
        if(n == 3)  return 2;
        if(n % 2 == 0)  return aux(n / 2);
        if((n + 1) % 4 == 0) return aux(n + 1);
        return aux(n - 1);
    }

}
