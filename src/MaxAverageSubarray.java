import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Sarnaglia on 1/16/17.
 */
public class MaxAverageSubarray {



    public static void main(String[] args){
        MaxAverageSubarray ms = new MaxAverageSubarray();
        System.out.println(ms.maxAverage(new int[]{1,12,-5,-6,50,3}, 3));
    }

    public double maxAverage(int[] nums, int k) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (max - min > 0.00001){
            double mid = min + (max - min) / 2;
            if(maxAverage(nums, k, mid)){
                min = mid;
            } else {
                max = mid;
            }
        }
        return (max + min) / 2.0;
    }

    public boolean maxAverage(int[] nums, int k, double targetMedian){
        LinkedList<Double> ll = new LinkedList<>();
        double accSum = 0;
        ll.addLast(accSum);
        for (int i = 0; i < k - 1; i++) {
            accSum += nums[i] - targetMedian;
            ll.addLast(accSum);
        }
        TreeSet<Double> ts = new TreeSet<>();
        for (int i = k - 1; i < nums.length; i++) {
            accSum += nums[i] - targetMedian;
            ts.add(ll.pollFirst());
            if(accSum >= ts.first()) return true;
            ll.addLast(accSum);
        }
        return false;
    }

}
