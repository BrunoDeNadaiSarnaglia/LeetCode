/**
 * Created by Sarnaglia on 4/1/17.
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if(num == 1)    return false;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
}
