import java.math.BigInteger;
import java.util.List;

/**
 * Created by Sarnaglia on 4/30/17.
 */
public class FindClosestPalindrome {

    public static void main(String[] args) {
        FindClosestPalindrome f = new FindClosestPalindrome();
        System.out.println(f.nearestPalindromic("123"));
        System.out.println(f.nearestPalindromic("1"));
        System.out.println(f.nearestPalindromic("9"));
        System.out.println(f.nearestPalindromic("10"));
    }

    public String nearestPalindromic(String n) {
        char[] array1 = new char[n.length()];
        char[] array2 = new char[n.length()];
        char[] array3 = new char[n.length()];
        for (int i = 0; i < (n.length() + 1) / 2; i++) {
            char ch = n.charAt(i);
            array1[i] = ((n.length() - 1) / 2 == i && ch != '0'? (char)(ch - 1): ch);
            array1[n.length() - 1 - i] = ((n.length() - 1) / 2 == i && ch != '0' ? (char)(ch - 1): ch);
            array2[i] = ch;
            array2[n.length() - 1 - i] = ch;
            array3[i] = ((n.length() - 1) / 2 == i && ch != '9'? (char)(ch + 1): ch);
            array3[n.length() - 1 - i] = ((n.length() - 1) / 2 == i && ch != '9'? (char)(ch + 1): ch);
        }
        String candidate1 = new String(array1);
        String candidate2 = new String(array2);
        String candidate3 = new String(array3);
        BigInteger bi1 = new BigInteger(candidate1);
        BigInteger bi2 = new BigInteger(candidate2);
        BigInteger bi3 = new BigInteger(candidate3);
        BigInteger bi4 = new BigInteger("10").pow(n.length() - 1).add(new BigInteger("-1"));
        BigInteger bi5 = new BigInteger("10").pow(n.length() - 1).add(new BigInteger("1"));
        BigInteger bi6 = new BigInteger("10").pow(n.length()).add(new BigInteger("-1"));
        BigInteger bi7 = new BigInteger("10").pow(n.length()).add(new BigInteger("1"));
        BigInteger b = new BigInteger(n);
        long difference = new BigInteger(n).longValue();
        BigInteger asd = b.pow(3);
        BigInteger[] l = new BigInteger[] { bi1, bi2, bi3, bi4, bi5, bi6, bi7 };
        for (int i = 0; i < l.length; i++) {
            if(!b.equals(l[i]) && (difference > b.subtract(l[i]).abs().longValue() || (difference == b.subtract(l[i]).abs().longValue() && l[i].compareTo(asd) < 0))) {
                asd = l[i];
                difference = b.subtract(l[i]).abs().longValue();
            }
        }
        return asd.toString();
    }


}
