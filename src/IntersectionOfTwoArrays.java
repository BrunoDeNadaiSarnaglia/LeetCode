import java.util.HashSet;

/**
 * Created by Bruno on 5/19/2016.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(Integer num : nums1){
            set1.add(num);
        }
        for(Integer num : nums2){
            if(set1.contains(num))  set2.add(num);
        }
        int[] intersection = new int[set2.size()];
        int i = 0;
        for (Integer num : set2){
            intersection[i++] = num;
        }
        return intersection;
    }
}
