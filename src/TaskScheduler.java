import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        t.leastInterval(new char[]{'A','A','A','B','B','B', 'B', 'Z'}, 3);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int max = 0;
        for (int i = 0; i < tasks.length; i++) {
            max = Math.max(max, ++map[tasks[i] - 'A']);
        }
        Character[] tasksOrder = new Character[26];
        for (int i = 0; i < 26; i++) {
            tasksOrder[i] = (char)('A' + i);
        }
        Arrays.sort(tasksOrder, (o1, o2) -> - map[(o1 - 'A')] + map[(o2 - 'A')]);
        int sum = 0;
        while (true) {
            int count = 0;
            for (int i = 0; i < n + 1 && map[tasksOrder[i] - 'A'] != 0; i++, count++) {
                map[tasksOrder[i] - 'A']--;
            }
            Arrays.sort(tasksOrder, (o1, o2) -> - map[(o1 - 'A')] + map[(o2 - 'A')]);
            if(map[tasksOrder[0] - 'A'] == 0) {
                sum += count;
                break;
            }
            sum += n + 1;
        }
        System.out.println(sum);
        return sum;
    }

}
