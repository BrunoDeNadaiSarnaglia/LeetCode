import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sarnaglia on 5/1/17.
 */
public class RemoveBoxes {

    public static void main(String[] args) {
        RemoveBoxes r = new RemoveBoxes();
        System.out.println(r.removeBoxes(new int[]{ 1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }

    public int removeBoxes(int[] boxes) {
        List<Integer> l = IntStream.of(boxes).boxed().collect(Collectors.toList());
        List<Integer> withoutSingleSeq = withoutSingleSeq(l);
        int sum = countSqr(l, withoutSingleSeq);
        HashMap<String, Integer> cache = new HashMap<>();
        return sum + removeBoxes(withoutSingleSeq, cache);
    }

    public int removeBoxes(List<Integer> boxes1, HashMap<String, Integer> cache) {
        if(boxes1.size() == 0)   return 0;
        if(cache.containsKey(boxes1.toString())) return cache.get(boxes1.toString());
        List<Integer> boxes = withoutSingleSeq(boxes1);
        int sum = countSqr(boxes1, boxes);
        int max = 0;
        for (int i = 0; i < boxes.size();) {
            int j = i + 1;
            while (j != boxes.size() && boxes.get(j) == boxes.get(i)) {
                j++;
            }
            max = Math.max(max, (int)Math.pow(j - i, 2) + removeBoxes(removeRange(boxes, i, j), cache));
            i = j;
        }
        return sum + max;
    }

    private List<Integer> removeRange(List<Integer> list, int i, int j) {
        List<Integer> clone = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            if(k < i || k >= j) {
                clone.add(list.get(k));
            }
        }
        return clone;
    }


    private List<Integer> withoutSingleSeq(List<Integer> boxes) {
        HashSet<Integer> oneOccurence = new HashSet<>();
        HashSet<Integer> moreThanOneOccurence = new HashSet<>();
        for (int i = 1, before = boxes.get(0); true; i++) {
            if (i == boxes.size() || boxes.get(i) != before) {
                if(oneOccurence.contains(before)) {
                    oneOccurence.remove(before);
                    moreThanOneOccurence.add(before);
                } else if(!moreThanOneOccurence.contains(before)) {
                    oneOccurence.add(before);
                }
                if(i == boxes.size())   break;
                before = boxes.get(i);
            }
        }
        List<Integer> withoutSingleValues = new ArrayList<>();
        for (int i = 0, j = 0; i < boxes.size(); i++) {
            if(moreThanOneOccurence.contains(boxes.get(i))) {
                withoutSingleValues.add(boxes.get(i));
            }
        }
        return withoutSingleValues;
    }

    private int countSqr(List<Integer> boxes, List<Integer> withoutSingleSeq) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer value: withoutSingleSeq) {
            set.add(value);
        }
        int sum = 0;
        for (int i = 0; i < boxes.size();) {
            if(!set.contains(boxes.get(i))) {
                int j = i + 1;
                while (j != boxes.size() && boxes.get(j) == boxes.get(i)) {
                    j++;
                }
                sum += Math.pow(j - i, 2);
                i = j;
            } else {
                i++;
            }
        }
        return sum;
    }
}
