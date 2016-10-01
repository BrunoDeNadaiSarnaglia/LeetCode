import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Bruno on 10/1/2016.
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> l = new LinkedList<int[]>();
        for (int[] peo : people){
            l.add(peo[1], peo);
        }
        return l.toArray(new int[people.length][]);
    }

}
