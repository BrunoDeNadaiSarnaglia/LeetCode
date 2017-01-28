import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 1/28/17.
 */
public class ValidNumber {


    public static void main(String[] args){
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("+.8"));
        System.out.println(vn.isNumber(" "));
        System.out.println(vn.isNumber("."));
        System.out.println(vn.isNumber("e"));
        System.out.println(vn.isNumber("0"));
        System.out.println(vn.isNumber(" 0.1 "));
        System.out.println(vn.isNumber("abc"));
        System.out.println(vn.isNumber("1 a"));
        System.out.println(vn.isNumber("2e10"));
        System.out.println(vn.isNumber("2.1e10.32"));
    }

    public boolean isNumber(String s) {
        HashSet<Character> h = new HashSet<Character>(Arrays.asList('0','1','2','3','4', '5', '6', '7', '8', '9', '.', 'e', '+', '-'));
        s = s.trim();
        if(!isValidContent(s, h))    return false;
        String[] split = s.split("e");
        if(split.length > 2)   return false;
        else if(split.length == 2){
            return isNumberWithoutExponent(split[0]) && isNumberWithoutExponent(split[1]);
        } else if(split.length == 1){
            return isNumberWithoutExponent(split[0]);
        } else {
            return false;
        }
    }

    private boolean isValidContent(String s, HashSet<Character> set){
        for (Character ch: s.toCharArray()) {
            if(!set.contains(ch))    return false;
        }
        return true;
    }

    private boolean isNumberWithoutExponent(String s){
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1);
        }
        String[] split = s.split("\\.");
        if(split.length > 2)   return false;
        else if(split.length == 2){
            return isInteger(split[0]) && isInteger(split[1]);
        } else if(split.length == 1){
            return isInteger(split[0]);
        } else {
            return false;
        }
    }

    private boolean isInteger(String s){
        return isValidContent(s, new HashSet<Character>(Arrays.asList('0','1','2','3','4','5','6','7', '8','9')));
    }

}
