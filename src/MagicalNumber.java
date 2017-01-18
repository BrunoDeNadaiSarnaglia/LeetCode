/**
 * Created by Sarnaglia on 1/15/17.
 */
public class MagicalNumber {

    public int magicalString(int n) {
        if(n <= 3) return 1;
        int i = 2;
        int j = 3;
        int pivot = 1;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        int count = 1;
        while (true){
            for (int k = 0; k < array[i] && j < array.length; k++) {
                array[j++] = pivot;
                count += (pivot == 1 ? 1 : 0);
            }
            if(j == array.length)   break;
            i++;
            pivot = (pivot == 1 ? 2 : 1);
        }
        return count;
    }

}
