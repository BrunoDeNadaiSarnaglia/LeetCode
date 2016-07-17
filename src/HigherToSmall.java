/**
 * Created by Bruno on 7/16/2016.
 */
public class HigherToSmall {
    public int guessNumber(int n){
        return guessNumber(1, n);
    }

    private int guessNumber(int i, int j){
        if(i == j)  return i;
        int mid = i + (j - i) / 2;
        int result = guess(mid);
        if(result == 0) return mid;
        if(result == 1) return guessNumber(mid + 1, j);
        return guessNumber(i, mid - 1);
    }

    public int guess(int num){
        return 0;
    }
}
