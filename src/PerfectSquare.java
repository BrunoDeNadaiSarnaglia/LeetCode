/**
 * Created by Bruno on 6/30/2016.
 */
public class PerfectSquare {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        int[] minSqrCount = new int[n + 1];
        for(int i = 0; i*i <= n; i++){
            minSqrCount[i*i] = 1;
            for(int j = 0; j + i*i <= n; j++){
                if(minSqrCount[j] == 0) continue;
                if(minSqrCount[j + i * i] == 0) minSqrCount[j + i * i] =  minSqrCount[j] + 1;
                minSqrCount[j + i * i] = Math.min(minSqrCount[j + i * i], minSqrCount[j] + 1);
            }
        }
        return  minSqrCount[n];
    }
}
