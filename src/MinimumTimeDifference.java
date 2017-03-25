import java.util.Arrays;
import java.util.List;

/**
 * Created by Sarnaglia on 3/25/17.
 */
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() <= 1)  return -1;
        int[] diffTime = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int hour    = Integer.parseInt(time.split(":")[0]);
            int minute  = Integer.parseInt(time.split(":")[1]);
            diffTime[i] = hour * 60 + minute;
        }
        Arrays.sort(diffTime);
        int min = diffTime[0] - diffTime[diffTime.length - 1] + 24 * 60;
        for (int i = 1; i < diffTime.length; i++) {
            min = Math.min(min, diffTime[i] - diffTime[i - 1]);
        }
        return min;
    }

}
