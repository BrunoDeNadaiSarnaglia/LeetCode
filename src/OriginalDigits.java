/**
 * Created by Bruno on 10/17/2016.
 */
public class OriginalDigits {




    public String originalDigits(String s) {
        int[] map = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'z') map[0]++;
            if(ch == 'w') map[2]++;
            if(ch == 'u') map[4]++;
            if(ch == 'x') map[6]++;
            if(ch == 'g') map[8]++;
            if(ch == 'o') map[1]++; // 1 - 0 - 2- 4
            if(ch == 'h') map[3]++; // 3 - 8
            if(ch == 'f') map[5]++; // 5 - 4
            if(ch == 's') map[7]++; // 7 - 6
            if(ch == 'i') map[9]++; //9-8-5-6
        }
        map[1] = map[1] - map[0] - map[2] - map[4];
        map[3] = map[3] - map[8];
        map[5] = map[5] - map[4];
        map[7] = map[7] - map[6];
        map[9] = map[9] - map[8] - map[5] - map[6];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
