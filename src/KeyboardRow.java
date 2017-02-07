import java.util.ArrayList;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class KeyboardRow {

    private boolean[] firstRow = new boolean[]{false, false, false, false, true, false, false, false, true, false, false, false, false, false, true, true, true, true, false, true, true, false, true, false, true, false};
    private boolean[] secondRow = new boolean[]{true, false, false, true, false, true, true, true, false, true, true, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false};
    private boolean[] thirdRow = new boolean[]{false, true,  true, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, true, false, true, false, true};
    private boolean[][] keyboard = new boolean[][] {firstRow, secondRow, thirdRow};

    public String[] findWords(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : words) {
            for (boolean[] map: keyboard) {
                if(findWords(s, map))   arrayList.add(s);
            }
        }
        String[] list = new String[arrayList.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = arrayList.get(i);
        }
        return list;
    }

    private boolean findWords(String s, boolean[] map){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && !map[s.charAt(i) - 'a']) return false;
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && !map[s.charAt(i) - 'A']) return false;
        }
        return true;
    }

}
