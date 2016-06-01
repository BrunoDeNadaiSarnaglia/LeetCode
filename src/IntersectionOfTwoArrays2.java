import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Bruno on 5/29/2016.
 */
public class IntersectionOfTwoArrays2 {

    public static void main(String[] args){
        IntersectionOfTwoArrays2 asd = new IntersectionOfTwoArrays2();
        System.out.println(asd.intersect(new int[]{1,2,2}, new int[]{1,2}));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> mapOccurences = MapOccurences(nums2);
        LinkedList<Integer> intersection = intersection(mapOccurences, nums1);
        int[] intersetionArray = LinkedListToArray(intersection);
        return intersetionArray;
    }

    private int[] LinkedListToArray(LinkedList<Integer> l){
        int[] array = new int[l.size()];
        int i = 0;
        for (Integer num: l) {
            array[i++] = num;
        }
        return array;
    }

    private LinkedList<Integer> intersection(HashMap<Integer, Integer> map, int[] nums){
        LinkedList<Integer> l = new LinkedList<Integer>();
        for (Integer num : nums) {
            if(!map.containsKey(num)) continue;
            map.put(num, map.get(num) - 1);
            l.add(num);
            if(map.get(num) == 0){
                map.remove(num);
            }
        }
        return l;
    }

    private HashMap<Integer, Integer> MapOccurences(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            Integer occurences = map.containsKey(num)? map.get(num) : 0;
            Integer adas = map.getOrDefault(num, 0);
            map.put(num, occurences + 1);
        }
        return map;
    }
}
