/**
 * Created by Sarnaglia on 4/30/17.
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = getMap(s1);
        int euristic = s1.length();
        for (int j = 0, i = - s1.length(); j < s2.length(); j++, i++) {
            char chj = s2.charAt(j);
            euristic += (map[chj] >= 0 ? 1 : -1);
            map[chj]++;
            if(i >= 0) {
                char chi = s2.charAt(i);
                euristic += (map[chi] > 0 ? -1 : 1);
                map[chi]--;
            }
            if(euristic == 0)   return true;
        }
        return false;
    }

    private int[] getMap(String s) {
        int[] map = new int[256];
        for (Character ch: s.toCharArray()) {
            map[ch]--;
        }
        return map;
    }

}
