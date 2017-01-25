/**
 * Created by Sarnaglia on 1/25/17.
 */
public class poorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie;
        int numPigs = 1;
        while (Math.pow(n + 1, numPigs) < buckets){
            numPigs++;
        }
        return numPigs;
    }

}
