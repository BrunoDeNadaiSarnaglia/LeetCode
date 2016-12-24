import java.util.Arrays;

/**
 * Created by Bruno on 12/24/2016.
 */
public class Heaters {

    public static void main(String[] args){
        Heaters h = new Heaters();
        System.out.println(h.findRadius(new int[]{1,2,3}, new int []{2}));
        System.out.println(h.findRadius(new int[]{1,2,3,4}, new int []{1,4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int i = 0;
        int j = 0;
        int max = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        while(i < houses.length){
            while (j + 1 < heaters.length && heaters[j + 1] <= houses[i])   j++;
            max = Math.max(
                    max,
                    Math.min(
                            Math.abs(heaters[j] - houses[i]),
                            Math.abs(
                                    (j + 1 < heaters.length ?
                                            heaters[j + 1] - houses[i] :
                                            Integer.MAX_VALUE))));
            i++;
        }
        return max;
    }

}
