/**
 * Created by Sarnaglia on 2/4/17.
 */
public class arrangingCoins {

    public int arrangeCoins(int n) {
        double x0 = 1000;
        while (true) {
            double x1 = x0 + ((double)n - (x0 * (x0 + 1))/ (2.0)) / x0;
            if(Math.abs(x1 - x0) < 0.0001) break;
        }
        double aux = Math.ceil(x0);
        if(Math.min(Math.ceil(x0) - x0, x0 - Math.floor(x0)) < 0.001)   return (int)Math.round(x0);
//        if(aux * (aux + 1) < 2 * (long) n)

        return (int)Math.floor(x0);
    }

}
