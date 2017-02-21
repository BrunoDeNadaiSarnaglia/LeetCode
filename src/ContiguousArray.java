/**
 * Created by Sarnaglia on 2/20/17.
 */
public class ContiguousArray {

    public int ContiguousArray(int[] array) {
        int max = 0;
        int[] zerosCountAcc = zerosCountAcc(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j <= array.length; j += 2) {
                max = Math.max(max, ((j - i) / 2 == zerosCountAcc[j] - zerosCountAcc[i] ? j - i : 0));
            }
        }
        return max;
    }

    private int[] zerosCountAcc(int[] array) {
        int[] zerosCount = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            zerosCount[i + 1] = zerosCount[i] + (array[i] == '0' ? 1 : 0);
        }
        return zerosCount;
    }
}
