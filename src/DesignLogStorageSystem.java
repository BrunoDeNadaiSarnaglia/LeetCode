import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sarnaglia on 7/4/17.
 */
public class DesignLogStorageSystem {

    List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4,7,10,13,16,19};

    public void put(int id, String timestamp) {
        timestamps.add(new String[]{Integer.toString(id), timestamp});
    }


    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for (int i = 0; i < timestamps.size(); i++) {
            if(timestamps.get(i)[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 ||
                    timestamps.get(i)[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) {
                res.add(Integer.parseInt(timestamps.get(i)[0]));
            }
        }
        return res;
    }
}
