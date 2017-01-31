import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 1/29/17.
 */
public class StringToInteger {

    public static void main(String[] args){
        StringToInteger t = new StringToInteger();
//        System.out.println(t.atoi("-2147483649"));
        System.out.println(t.atoi("        112469032d53"));
//        System.out.println(t.atoi("123123123123123123123"));
//        System.out.println(t.atoi("1.0"));
//        System.out.println(t.atoi("         k"));
    }

    public int atoi(String str) {
        str = str.trim();
        str = filter2(str, new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '.')));
        return preToInt(str.split("\\.")[0]);
    }

    public int preToInt(String s){
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '-'){
            int val = toInt(s.substring(1));
            return (val == Integer.MAX_VALUE ? Integer.MIN_VALUE : -val);
        }
        if(s.charAt(0) == '+'){
            return toInt(s.substring(1));
        }
        return toInt(s);
    }

    public int toInt(String s){
        s = filter2(s, new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')));
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && (s.charAt(i) - '0') >= Integer.MAX_VALUE - 10 * num))    return Integer.MAX_VALUE;
            num = 10 * num + (s.charAt(i) - '0');
        }
        return num;
    }

    private String filter(String s, HashSet<Character> set){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    private String filter2(String s, HashSet<Character> set){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

}
