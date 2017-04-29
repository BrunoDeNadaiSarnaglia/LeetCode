import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Sarnaglia on 4/28/17.
 */
public class beautifullArrangement {

    public int countArrangement(int N) {
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            array.add(list);
            for (int j = 1; j < i + 1; j++) {
                if((i + 1) % j == 0){
                    list.add(j);
                }
            }
            for (int j = i + 1; j <= N; j += (i + 1)) {
                list.add(j);
            }
        }
        return helper(array, 0, new HashSet<Integer>());
    }

    private int helper(List<List<Integer>> array, int i, HashSet<Integer> set) {
        if(i == array.size())   return 1;
        int sum = 0;
        for (Integer j: array.get(i)) {
            if(set.contains(j)) continue;
            set.add(j);
            sum += helper(array, i + 1, set);
            set.remove(j);
        }
        return sum;
    }

}
