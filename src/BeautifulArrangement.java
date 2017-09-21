import java.util.Arrays;

/**
 * Created by Sarnaglia on 9/20/17.
 */
public class BeautifulArrangement {

    public int[] constructArray(int n, int k) {
        int[] l = new int[n];
        for (int i = k; i < n; i++) {
            l[i] = i + 1;
        }
        for (int i = k - 1; i >= 0; i--) {
            if((k - i) % 2 == 0) {
                l[i] = k + 1 - (k - i) / 2;
            } else {
                l[i] = (k + 1 - i) / 2;
            }
        }
        System.out.println(Arrays.toString(l));
        return l;
    }
}
