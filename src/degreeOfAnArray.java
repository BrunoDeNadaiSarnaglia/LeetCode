import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 1/7/18.
 */
public class degreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> elementsCount = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            elementsCount.put(nums[i], elementsCount.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, elementsCount.get(nums[i]));
        }
        HashMap<Integer, Integer> firstOccurences = new HashMap();
        HashMap<Integer, Integer> secondOccurences = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(elementsCount.get(nums[i]) == maxFreq){
                firstOccurences.putIfAbsent(nums[i], i);
                secondOccurences.put(nums[i], i);
            }
        }
        int maxSubArrayWithMaxFreqLen = Integer.MAX_VALUE;
        for (Integer maxFreqElement: firstOccurences.keySet()) {
            int subArrayWithMaxFreqLen = secondOccurences.get(maxFreqElement) - firstOccurences.get(maxFreqElement) + 1;
            maxSubArrayWithMaxFreqLen = Math.min(maxSubArrayWithMaxFreqLen, subArrayWithMaxFreqLen);
        }
        return maxSubArrayWithMaxFreqLen;
    }
}
