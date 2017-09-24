import java.util.*;

/**
 * Created by Sarnaglia on 9/24/17.
 */
public class bulbSwitcher2 {

    public int flipLights(int n, int m) {
        HashSet<List<Boolean>> set = new HashSet<>();
        List<Boolean> list = new ArrayList<>(Arrays.asList(new Boolean[n]));
        Collections.fill(list, Boolean.TRUE);
        set.add(list);
        for (int i = 0; i < m; i++) {
            HashSet<List<Boolean>> nextSet = new HashSet<>();
            for (List<Boolean> l: set) {
                nextSet.add(flipAll(l));
                nextSet.add(flipEven(l));
                nextSet.add(flipOdd(l));
                nextSet.add(flipThreeTimesPlusOne(l));
            }
            set = nextSet;
        }
        return set.size();
    }

    private List<Boolean> flipAll(List<Boolean> l) {
        List<Boolean> flipped = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            flipped.add(!l.get(i));
        }
        return flipped;
    }

    private List<Boolean> flipEven(List<Boolean> l) {
        List<Boolean> flipped = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if(i % 2 == 0) {
                flipped.add(!l.get(i));
            } else {
                flipped.add(l.get(i));
            }
        }
        return flipped;
    }

    private List<Boolean> flipOdd(List<Boolean> l) {
        List<Boolean> flipped = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if(i % 2 == 1) {
                flipped.add(!l.get(i));
            } else {
                flipped.add(l.get(i));
            }
        }
        return flipped;
    }


    private List<Boolean> flipThreeTimesPlusOne(List<Boolean> l) {
        List<Boolean> flipped = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if((i  - 1) % 3 == 0) {
                flipped.add(!l.get(i));
            } else {
                flipped.add(l.get(i));
            }
        }
        return flipped;
    }
}
