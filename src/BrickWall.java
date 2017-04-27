import java.util.HashMap;
import java.util.List;

/**
 * Created by Sarnaglia on 4/27/17.
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int height = wall.size();
        for (int i = 0; i < wall.size(); i++) {
            int col = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                col += wall.get(i).get(j);
                map.putIfAbsent(col, height);
                map.put(col, map.get(col) - 1);
            }
        }
        if(map.size() == 0) return height;
        int min = Integer.MAX_VALUE;
        for (Integer val: map.values()) {
            min = Math.min(min, val);
        }
        return min;
    }

}
