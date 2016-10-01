/**
 * Created by Bruno on 10/1/2016.
 */
public class toHex {

    private char[] dicHexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6' ,'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public String toHex(int num) {
        if(num == 0)    return "0";
        boolean isPositive = true;
        if(num < 0) {
            if(num == Integer.MIN_VALUE)    return "80000000";
            num = Integer.MAX_VALUE + (num + 1);
            isPositive = false;
        }
        StringBuilder sb = new StringBuilder();
        toHex(num, sb, isPositive);
        return sb.toString();
    }

    private void toHex(int num, StringBuilder sb, boolean isPositive){
        if(num < 16){
            num = (isPositive? num : num + 8);
            sb.append(dicHexDigits[num]);
        }
        else{
            toHex(num / 16, sb, isPositive);
            sb.append(dicHexDigits[num % 16]);
        }
    }

}
