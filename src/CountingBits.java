/**
 * Created by Bruno on 7/17/2016.
 */
public class CountingBits {

    public static void main(String[] args){
        CountingBits cb = new CountingBits();
        Utils.printArray(cb.countBits(5));
    }

        public int[] countBits(int num) {
            int[] countBitsArray = new int[num + 1];
            countBitsArray[0] = 0;
            for (int i = 1; i <= num; i++) {
                countBitsArray[i] = countBitsArray[i - 1] - leastSigBitOrder(i - 1) + 1;
            }
            return countBitsArray;
        }


        private int leastSigBitOrder(int num){
            int order = 0;
            while(((num >> order) & 1) != 0){
                order++;
            }
            return order;
        }

}
