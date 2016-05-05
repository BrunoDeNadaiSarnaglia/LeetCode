/**
 * Created by Bruno on 5/5/2016.
 */
public class IsPowerOfFour {

    public boolean isPowerOfFour(int num) {
        if(num == 0 || (num&(num-1)) != 0){
            return false;
        }
        if((num&0x55555555) == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        IsPowerOfFour power = new IsPowerOfFour();
        System.out.println(power.isPowerOfFour(16));
    }

}
