import java.util.Arrays;

/**
 * Created by Sarnaglia on 4/29/17.
 */
public class NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        int it = n / 10;
        int i = 1;
        while (it != 0) {
            if (digit(n, i) < digit(n, i - 1)) {
                break;
            }
            i++;
            it /= 10;
        }
        if(it == 0) return -1;
        for (int j = 0; j < i; j++) {
            if (digit(n, i) < digit(n, j)) {
                int csd = swap(n, i, j);
                if(csd < n) return -1;
                int inax = sort(csd, i);
                return ((csd / (int) Math.pow(10, i)) * (int) Math.pow(10, i)) + inax;
            }
        }
        return -1;
    }

    private int digit(int n, int i) {
        return (n / (int)Math.pow(10, i)) % 10;
    }

    private int swap(int n, int i, int j) {
        int digitI = digit(n, i);
        int digitJ = digit(n, j);
        return n + ((digitJ - digitI) * (int)Math.pow(10, i)) + ((digitI - digitJ) * (int)Math.pow(10, j));
    }

    private int sort(int n, int i) {
        int[] array = new int[i];
        for (int j = 0; j < array.length; j++, n /= 10) {
            array[j] = n % 10;
        }
        Arrays.sort(array);
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum = array[j] + sum * 10;
        }
        return sum;
    }

}
