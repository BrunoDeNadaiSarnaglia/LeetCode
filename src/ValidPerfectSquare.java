/**
 * Created by Bruno on 6/28/2016.
 */
public class ValidPerfectSquare {

    public static void main(String[] args){
        ValidPerfectSquare v = new ValidPerfectSquare();
        v.isPerfectSquare(25);
    }

    public boolean isPerfectSquare(int num) {
        int i = 1;
        int j = num;
        while(j >= i){
            int mid = i + (j - i) / 2;
            System.out.println(mid);
            if(mid == num / mid && num % mid == 0){
                return true;
            } else if(mid < num/mid || (mid == num / mid && num % mid != 0)){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

}
