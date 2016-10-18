/**
 * Created by Bruno on 10/17/2016.
 */
public class longestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0;
        int j = 0;
        int asd = 0;
        while (true){
            int max = max(map);
            if(j - i - max > k){
                map[s.charAt(i++) - 'A']--;
            } else {
                asd = Math.max(asd, j - i);
                if(j >= s.length()) break;
                map[s.charAt(j++) - 'A']++;
            }
        }
        return asd;
    }

    private int max(int[] array){
        int m = 0;
        for (int i = 0; i < array.length; i++){
            m = Math.max(m, array[i]);
        }
        return m;
    }

}
