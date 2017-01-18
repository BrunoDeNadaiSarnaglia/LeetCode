import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 5/15/2016.
 */
public class AddOperator {

    public static void main(String[] args){
        AddOperator ao = new AddOperator();
        System.out.println(ao.addOperators("123", 6));
        System.out.println(ao.addOperators("232", 8));
        System.out.println(ao.addOperators("105", 5));
        System.out.println(ao.addOperators("3456237490", 9191));
        System.out.println(ao.addOperators("000", 0));
        System.out.println(ao.addOperators("000", 2));
    }

    public List<String> addOperators(String num, int target) {
        List<String> validExpressions = new ArrayList<String>();
        for (int i = 0; i < num.length(); i++) {
            long val = Long.parseLong(num.substring(0, i + 1));
            if(i != 0 && num.charAt(0) == '0')  continue;
            helper(num, num.substring(0, i + 1), i + 1, val, target, val, validExpressions);
        }
        return validExpressions;
    }

    private void helper(String num, String expression, int i, long eval, long target, long lastNum, List<String> validExpressions){
        if(i == num.length() && eval == target){
            validExpressions.add(expression);
        }
        for (int j = i; j < num.length(); j++) {
            long nextNum = Long.parseLong(num.substring(i, j + 1));
            if(j != i && num.charAt(i) == '0')  return;
            helper(num, expression + "+" + nextNum, j + 1, eval + nextNum, target, nextNum, validExpressions);
            helper(num, expression + "-" + nextNum, j + 1, eval - nextNum, target, -nextNum, validExpressions);
            helper(num, expression + "*" + nextNum, j + 1, eval - lastNum + lastNum * nextNum, target, lastNum * nextNum, validExpressions);
        }
    }

}
