import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

public class FindKThSmallestPairDistance {

  private int getCount(int[] nums, int mid) {
    int count = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      while(j + 1 < nums.length && nums[j + 1] - nums[i] <= mid) {
        j++;
      }
      count += j - i;
    }
    return count;
  }

  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int maxSum = nums[nums.length - 1] - nums[0];
    int minSum = nums[1] - nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      minSum = Math.min(minSum, nums[i + 1] - nums[i]);
    }
    return binarySearch(nums, minSum, maxSum, k);
  }

  private int binarySearch(int[] nums, int i, int j, int k) {
    if(j < i) return i;
    int mid = (j - i) / 2 + i;
    int count = getCount(nums, mid);
    if(k > count) return binarySearch(nums, mid + 1, j, k);
    return binarySearch(nums, i, mid - 1, k);
  }

  // private class Pair {
  //   int i;
  //   int j;

  //   public Pair(int i, int j) {
  //     this.i = i;
  //     this.j = j;
  //   }

  //   public int getI() {
  //     return this.i;
  //   }

  //   public int getJ() {
  //     return this.j;
  //   }
  // }
  // public int smallestDistancePair(int[] nums, int k) {
  //   PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
  //     @Override
  //     public int compare(Pair p1, Pair p2) {
  //       return (nums[p1.getJ()] - nums[p1.getI()]) - (nums[p2.getJ()] - nums[p2.getI()]);
  //     }
  //   });
  //   Arrays.sort(nums);
  //   for (int i = 0; i < nums.length - 1; i++) {
  //     pq.add(new Pair(i, i + 1));
  //   }
  //   for (int i = 0; i < k - 1; i++) {
  //     Pair p = pq.poll();
  //     if(p.getJ() < nums.length - 1) {
  //       pq.add(new Pair(p.getI(), p.getJ() + 1));
  //     }
  //   }
  //   Pair distantePair = pq.poll();
  //   return nums[distantePair.getJ()] - nums[distantePair.getI()];
  // }
}
