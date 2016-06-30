import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 6/30/2016.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> UglyNumbers = new ArrayList<Integer>();
        UglyNumbers.add(1);
        int[] idxArray = new int[primes.length];
        for(int i = 0; i < n; i++){
            int nextNum = nextUglyNumber(UglyNumbers, primes, idxArray);
            UglyNumbers.add(nextNum);
        }
        return UglyNumbers.get(UglyNumbers.size()-1);
    }

    private int nextUglyNumber(List<Integer> UglyNumbers, int[] primes, int[] idxArray){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < primes.length; i++){
            if(primes[i] == 1)  continue;
            int nextNum = UglyNumbers.get(idxArray[i]) * primes[i];
            min = Math.min(min, nextNum);
        }
        for(int i = 0; i < primes.length; i++){
            if(primes[i] == 1)  continue;
            int nextNum = UglyNumbers.get(idxArray[i]) * primes[i];
            if(nextNum == min)  idxArray[i]++;
        }
        return min;
    }
}
