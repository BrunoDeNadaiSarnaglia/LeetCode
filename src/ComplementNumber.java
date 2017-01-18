/**
 * Created by Sarnaglia on 1/14/17.
 */
public class ComplementNumber {

    public int findComplement(int num) {
        int pivot = 1;
        int i = 32;
        for (; i >= 0; i--) {
            if((num & (pivot << i) ) != 0){
                break;
            }
        }
        for (; i >= 0; i--) {
            num ^= (pivot << i);
        }
        System.out.println(Integer.toBinaryString(num));
        return num;
    }

}
