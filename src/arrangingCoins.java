/**
 * Created by Sarnaglia on 2/4/17.
 */
public class arrangingCoins {

    public int arrangeCoins(int n) {
        int i = 0;
        int j = n;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(mid <= (2 * n) / (mid + 1))  i = mid + 1;
            else j = mid - 1;
        }
        return j;
    }

}
