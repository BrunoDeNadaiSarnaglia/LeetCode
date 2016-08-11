/**
 * Created by Bruno on 8/11/2016.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[256];
        for (Character ch: ransomNote.toCharArray()) {
            map[ch]--;
        }
        for (Character ch: magazine.toCharArray()) {
            map[ch]++;
        }
        for (Integer count: map) {
            if(count < 0)   return false;
        }
        return true;
    }

}
