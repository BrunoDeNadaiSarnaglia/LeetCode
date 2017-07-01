import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Sarnaglia on 7/1/17.
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list2.length > list1.length) {
            return findRestaurant(list2, list1);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int max = Integer.MAX_VALUE;
        List<String> options = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(!map.containsKey(list2[i])) continue;
            else if(i + map.get(list2[i]) > max) continue;
            else if(i + map.get(list2[i]) == max) options.add(list2[i]);
            else {
                options = new ArrayList<>();
                options.add(list2[i]);
                max = i + map.get(list2[i]);
            }
        }
        String[] optionsArray = new String[options.size()];
        optionsArray = options.toArray(optionsArray);
        return optionsArray;
    }
}
