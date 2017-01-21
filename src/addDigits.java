/**
 * Created by Sarnaglia on 1/20/17.
 */
public class addDigits {

    public int addDigits(int num) {
        if(num <= 9)    return num;
        int sumDigits = sumDigits(num);
        return addDigits(num);
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
