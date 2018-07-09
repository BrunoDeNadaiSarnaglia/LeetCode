public class SearchRotatedSortedArray2 {
  public boolean search(int[] nums, int target) {
    return search(nums, 0, nums.length - 1, target);
  }

  private boolean search(int[] nums, int i, int j, int target) {
    if(j < i) return false;
    if(i == j)  return nums[i] == target;
    if(nums[i] == nums[j])  return search(nums, i, j - 1, target);
    int mid = (i + j) / 2;
    if(target == nums[mid]) return true;
    if(target > nums[i]) {
      if(nums[mid] < target && nums[mid] >= nums[i]) {
        return search(nums, mid + 1, j, target);
      }
      return search(nums, i, mid - 1, target);
    } else if(nums[mid] > target && nums[mid] <= nums[j]) {
      return search(nums, i, mid - 1, target);
    }
    return search(nums, mid + 1, j, target);
  }
}
