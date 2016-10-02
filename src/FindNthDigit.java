/**
 * Created by Bruno on 10/1/2016.
 */
public class FindNthDigit {


    public static void main(String[] args){
        FindNthDigit f = new FindNthDigit();
        System.out.println(f.findNthDigit(8));
        System.out.println(f.findNthDigit(13));
        System.out.println(f.findNthDigit(14));
        System.out.println(f.findNthDigit(15));
    }

    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));

    }

}
