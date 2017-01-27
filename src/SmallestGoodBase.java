/**
 * Created by Sarnaglia on 1/25/17.
 */
public class SmallestGoodBase {

    public static void main(String[] args){
        SmallestGoodBase sb = new SmallestGoodBase();
//        System.out.println(sb.smallestGoodBase("15"));
//        System.out.println(sb.smallestGoodBase("4681"));
        System.out.println(sb.smallestGoodBase("1000000000000000000"));
    }

    public String smallestGoodBase(String n) {
        long val = Long.parseLong(n);
        long ans = val - 1;
        long j;
        long k = val - 1;
        for (int countOnes = 3; countOnes < 18; countOnes++) {
            j = 2;
            while (k >= j){
                long mid = j + (k - j) / 2;
                long oneNumber = getOneBasedNum(mid, countOnes);
                if(oneNumber < 0 || oneNumber > val){
                    k = mid - 1;
                } else {
                    j = mid + 1;
                }
            }
            if(k == 1)  break;
            if(getOneBasedNum(k, countOnes) == val){
                ans = k;
            }
        }
        return Long.toString(ans);
    }


    private long getOneBasedNum(long base, long countOnes){
        long accFactor = 1;
        long sum = 0;
        for (int i = 0; i < countOnes; i++) {
            if(sum > Long.MAX_VALUE - accFactor) return -1;
            sum += accFactor;
            if(i != countOnes - 1 && base >= Long.MAX_VALUE / accFactor) return -1;
            accFactor *= base;
        }
        return sum;
    }

}
