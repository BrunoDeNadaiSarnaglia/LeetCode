import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Sarnaglia on 1/14/17.
 */
public class SlidingWindowMedian {


    private class TreeSetDuplicate {

        private int size;
        private TreeSet<Integer> set;
        private HashMap<Integer, Integer> map;

        public TreeSetDuplicate(){
            set = new TreeSet<>();
            map = new HashMap<>();
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public Integer GetMax(){
            return set.last();
        }

        public Integer getMin(){
            return set.first();
        }

        public void insert(Integer num){
            if(set.contains(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                set.add(num);
                map.put(num, 1);
            }
            this.size++;
        }

        public void remove(Integer num){
            if(!set.contains(num))  return;
            map.put(num, map.get(num) - 1);
            if(map.get(num) == 0){
                map.remove(num);
                set.remove(num);
            }
            this.size--;
        }

        public int size(){
            return this.size;
        }

        public boolean contains(int num){
            return this.set.contains(num);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSetDuplicate lowerHalfSet = new TreeSetDuplicate();
        TreeSetDuplicate upperHalfSet = new TreeSetDuplicate();
        double[] medianArray = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if(lowerHalfSet.size() == 0 || nums[i] <= lowerHalfSet.GetMax()){
                lowerHalfSet.insert(nums[i]);
            } else {
                upperHalfSet.insert(nums[i]);
            }
            if(i - k >= 0){
                if(lowerHalfSet.contains(nums[i - k])){
                    lowerHalfSet.remove(nums[i - k]);
                } else {
                    upperHalfSet.remove(nums[i - k]);
                }
            }
            while (lowerHalfSet.size() > upperHalfSet.size() + 1) {
                int max = lowerHalfSet.GetMax();
                lowerHalfSet.remove(max);
                upperHalfSet.insert(max);
            }
            while (upperHalfSet.size() > lowerHalfSet.size()){
                int min = upperHalfSet.getMin();
                upperHalfSet.remove(min);
                lowerHalfSet.insert(min);
            }
            if(i >= k - 1){
                if(lowerHalfSet.size() == upperHalfSet.size()){
                    medianArray[i - k + 1] = (((double) lowerHalfSet.GetMax()) + ((double) upperHalfSet.getMin())) / 2.0;
                    System.out.println(lowerHalfSet.GetMax());
                    System.out.println(upperHalfSet.getMin());
                } else {
                    medianArray[i - k + 1] = (double) lowerHalfSet.GetMax();
                }
            }
        }
        return medianArray;
    }

}
