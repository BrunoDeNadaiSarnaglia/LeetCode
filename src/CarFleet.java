import java.util.Arrays;

public class CarFleet {
  public int carFleet(int target, int[] position, int[] speed) {
    if(position == null || position.length == 0)  return 0;
    Map<Integer, Float> map = new HashMap<>();
    for(int i = 0; i < position.length; i++) {
      map.put(position[i], ((float)(target - position[i])/ (float) speed[i]));
    }
    Arrays.sort(position);
    int count = 1;
    int initFleet = position.length - 1;
    for (int i = position.length - 2; i >= 0; i--) {
      if(map.get(position[initFleet]) < map.get(position[i])) {
        initFleet = i;
        count++;
      }
    }
    return count;
  }
}
