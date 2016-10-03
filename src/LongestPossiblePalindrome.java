/**
 * Created by Bruno on 10/2/2016.
 */
public class LongestPossiblePalindrome {


    public static void main(String[] args){
        LongestPossiblePalindrome l = new LongestPossiblePalindrome();
        System.out.println(l.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        int[] map = new int[256];
        for (Character ch : s.toCharArray()){
            map[ch]++;
        }
        for (int i = 0; i < 256; i++) {
            if(map[i] != 0)
                System.out.println((char)i + ":" + map[i]);
        }
        int sum = 0;
        int oddCount = 0;
        for (Integer num: map) {
            sum += num;
            oddCount += num % 2;
        }
        return sum - oddCount + (oddCount == 0? 0 : 1);
    }
}
