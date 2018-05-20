public class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    int idx = binarySearch(letters, 0, letters.length - 1, target);
    return letters[idx >= letters.length ? 0 : idx];
  }

  private int binarySearch(char[] letters, int i, int j, char target) {
    if(j < i) return i;
    int mid = (j - i) / 2 + i;
    if(target >= letters[mid]) return binarySearch(letters, mid + 1, j, target);
    else return binarySearch(letters, i, mid - 1, target);
  }
}
