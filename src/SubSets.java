import java.util.ArrayList;

public class SubSets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    return subsets(nums, 0, subsets);
  }

  private List<List<Integer>> subsets(int[] nums, int i, List<List<Integer>> previousSubsets) {
    if(i == nums.length)  return previousSubsets;
    List<List<Integer>> subsets = new ArrayList<>();
    for(List<Integer> l : previousSubsets) {
      subsets.add(l);
      List<Integer> nl = new ArrayList<>(l);
      nl.add(nums[i]);
      subsets.add(nl);
    }
    return subsets(nums, i + 1, subsets);
  }


  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    int max = Math.pow(2, nums.length) - 1;
    for (int i = 0; i <= max; i++) {
      subsets.add(generateSetFromInt(nums, i));
    }
    return subsets
  }

  private List<Integer> generateSetFromInt(int[] nums, int i) {
    List<Integer> l = new ArrayList<>();
    for (int j = 1, k = 0; j <= i; j <<= 1, k++) {
      if((j & i) != 0) {
        l.add(nums[i]);
      }
    }
  }

}
