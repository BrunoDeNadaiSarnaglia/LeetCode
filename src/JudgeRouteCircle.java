import java.util.HashMap;

/**
 * Created by Sarnaglia on 9/3/17.
 */
public class JudgeRouteCircle {
        HashMap<Character, Integer> horizontalDirection;
        HashMap<Character, Integer> verticalDirection;

        public JudgeRouteCircle(){
            horizontalDirection = new HashMap<>();
            horizontalDirection.put('R', 1);
            horizontalDirection.put('L', -1);
            verticalDirection = new HashMap<>();
            verticalDirection.put('U', 1);
            verticalDirection.put('D', -1);
        }

        public boolean judgeCircle(String moves) {
            int horizontal = 0;
            int vertical = 0;
            for (Character direction: moves.toCharArray()) {
                horizontal += this.horizontalDirection.getOrDefault(direction, 0);
                vertical += this.verticalDirection.getOrDefault(direction, 0);
            }
            return horizontal == 0 && vertical == 0;
        }
}
