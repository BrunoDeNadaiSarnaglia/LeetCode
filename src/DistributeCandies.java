import java.util.HashSet;

/**
 * Created by Sarnaglia on 6/24/17.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        int max = candies.length / 2;
        HashSet<Integer> typeOfCandies = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            typeOfCandies.add(candies[i]);
            if(typeOfCandies.size() > max)  return max;
        }
        return typeOfCandies.size();
    }

}
